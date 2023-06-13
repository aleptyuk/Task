package utils;

import enums.Citizenship;
import enums.Gender;
import identities.Citizen;

import static utils.EnumUtils.getRandomItemFromEnum;
import static utils.RandomUtil.*;

public class CitizenCreator {
    public static Citizen createCitizen() {
        return Citizen
                .builder()
                .gender(getRandomItemFromEnum(Gender.values()))
                .dateOfBirth(getRandomDateOfBirthday())
                .orderNumber(getRandomNumberWithDigits(3))
                .citizenship(getRandomItemFromEnum(Citizenship.values()))
                .cityCode(getRandomCityCode())
                .build();
    }
}
