package utils;

import java.util.List;

import static utils.RandomUtil.getRandomListElement;

public class EnumUtils {
    public static <T extends Enum<T>> String getRandomItemFromEnum(T[] items) {
        return getRandomListElement(List.of(items)).name();
    }
}
