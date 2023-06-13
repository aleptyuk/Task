package identities;

import lombok.Builder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import static enums.Citizenship.*;
import static enums.Gender.MALE;

@Builder
public class Citizen {

    private static final String NON_RESIDENTS_CODE = "9";
    private static final String FOREIGN_RESIDENT_IN_ROMANIA_MALE_CODE = "7";
    private static final String FOREIGN_RESIDENT_IN_ROMANIA_FEMALE_CODE = "8";
    private static final String ROMANIAN_MALE_TWENTIES_CENTURY_CODE = "1";
    private static final String ROMANIAN_FEMALE_TWENTIES_CENTURY_CODE = "2";
    private static final String ROMANIAN_MALE_NINETEENS_CENTURY_CODE = "3";
    private static final String ROMANIAN_FEMALE_NINETEENS_CENTURY_CODE = "4";
    private static final String ROMANIAN_MALE_TWENTY_ONES_CENTURY_CODE = "5";
    private static final String ROMANIAN_FEMALE_TWENTY_ONES_CENTURY_CODE = "6";
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
    private static final String CHECK_NUMBER = "279146358279";

    private String gender;
    private Date dateOfBirth;
    private String cityCode;
    private String citizenship;
    private String orderNumber;

    public String createCNP() {
        StringBuilder cnp = new StringBuilder();

        if (citizenship.equals(NON_RESIDENTS.name())) {
            cnp.append(NON_RESIDENTS_CODE);
        } else if (citizenship.equals(FOREIGN_RESIDENT_IN_ROMANIA.name())) {
            if (gender.equals(MALE.name())) {
                cnp.append(FOREIGN_RESIDENT_IN_ROMANIA_MALE_CODE);
            } else {
                cnp.append(FOREIGN_RESIDENT_IN_ROMANIA_FEMALE_CODE);
            }
        } else if (citizenship.equals(ROMANIAN.name())) {
            cnp.append(generateCodeByDateBirthAndGender());
        } else throw new RuntimeException("Citizenship type is not correct");

        String dateOfBirthDay = sdf.format(dateOfBirth);
        //get year
        cnp.append(dateOfBirthDay, 8, 10)
                // get month
                .append(dateOfBirthDay, 3, 5)
                //get day
                .append(dateOfBirthDay, 0, 2)
                .append(cityCode)
                .append(orderNumber);
        cnp.append(getControlNumber(cnp.toString()));
        return String.valueOf(cnp);
    }

    private String generateCodeByDateBirthAndGender() {
        try {
            if (dateOfBirth.after(sdf.parse("01.01.1900")) && dateOfBirth.before(sdf.parse("31.12.1999"))) {
                if (gender.equals(MALE.name())) {
                    return ROMANIAN_MALE_TWENTIES_CENTURY_CODE;
                } else {
                    return ROMANIAN_FEMALE_TWENTIES_CENTURY_CODE;
                }
            } else if (dateOfBirth.after(sdf.parse("01.01.1800")) && dateOfBirth.before(sdf.parse("31.12.1899"))) {
                if (gender.equals(MALE.name())) {
                    return ROMANIAN_MALE_NINETEENS_CENTURY_CODE;
                } else {
                    return ROMANIAN_FEMALE_NINETEENS_CENTURY_CODE;
                }
            } else if (dateOfBirth.after(sdf.parse("01.01.2000")) && dateOfBirth.before(sdf.parse("31.12.2099"))) {
                if (gender.equals(MALE.name())) {
                    return ROMANIAN_MALE_TWENTY_ONES_CENTURY_CODE;
                } else {
                    return ROMANIAN_FEMALE_TWENTY_ONES_CENTURY_CODE;
                }
            } else throw new RuntimeException("Date of Birth is not correct");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getControlNumber(String cnp) {
        int[] checkNumber = Arrays.stream(CHECK_NUMBER.split(""))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] cnpDigits = Arrays.stream(cnp.split(""))
                .mapToInt(Integer::parseInt)
                .toArray();

        int sumDigits = 0;
        for (int i = 0; i < cnpDigits.length; i++) {
            sumDigits += cnpDigits[i] * checkNumber[i];
        }

        int remainderOfDivision = sumDigits % 11;
        return String.valueOf(remainderOfDivision == 10 ? 1 : remainderOfDivision);
    }
}
