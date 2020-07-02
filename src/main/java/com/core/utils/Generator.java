package com.core.utils;

import org.apache.commons.lang3.RandomStringUtils;

public class Generator {

    public static int genInt(int from, int to) {
        return Integer.parseInt(RandomStringUtils.randomNumeric(from, to));
    }

    public static String getRandomStringNumber() {
        return RandomStringUtils.randomNumeric(10);
    }

    public static String genString(int length) {
        return RandomStringUtils.randomAlphabetic(length);
    }

    public static String getRandomStringNumber(int length) {
        return RandomStringUtils.randomNumeric(length);
    }

    public static String genMobilePhone(int length) {
        return "555" + getRandomStringNumber(7);
    }

    public static String genEmail() {
        return "testemail+" + getRandomStringNumber(7) + "@mail.com";
    }

    public static String genAddress() {
        return "Test " + Generator.genString(4) + " Avenue, " + Generator.genInt(1, 1000);
    }
}
