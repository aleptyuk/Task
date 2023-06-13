package utils;

import com.github.javafaker.Faker;

import java.util.Date;
import java.util.List;
import java.util.Random;

public class RandomUtil {
    private static final Random random = new Random();
    private static final Faker faker = new Faker();

    public static <T> T getRandomListElement(List<T> listCollection) {
        if (listCollection == null || listCollection.isEmpty()) {
            throw new IllegalArgumentException("Source collection must be defined and contain at least one element");
        }
        int randomIndex = random.nextInt(listCollection.size());
        return listCollection.get(randomIndex);
    }

    public static Date getRandomDateOfBirthday() {
        return faker.date().birthday(0, 223);
    }

    public static String getRandomNumberWithDigits(int numberOfDigits) {
        return faker.number().digits(numberOfDigits);
    }

    public static String getRandomCityCode() {
        String number = String.valueOf(faker.number().numberBetween(1, 52));
        return number.length() == 1 ? 0 + number : number;
    }
}
