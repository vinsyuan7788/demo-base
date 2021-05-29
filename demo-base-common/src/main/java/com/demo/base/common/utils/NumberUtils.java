package com.demo.base.common.utils;

/**
 *  This class is used for number utility
 *
 * @author Vince Yuan
 * @date 02/02/2021
 */
public class NumberUtils {

    /**
     *  Privatize no-args constructor
     */
    private NumberUtils() { }

    public static boolean isNumber(String string) {
        return org.apache.commons.lang3.math.NumberUtils.isCreatable(String.valueOf(string));
    }

    public static boolean isNotNumber(String string) {
        return !isNumber(string);
    }
}
