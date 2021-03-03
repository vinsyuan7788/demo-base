package com.demo.base.common.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * @author Vince Yuan
 * @date 02/02/2021
 */
public class DateUtils {

    /**
     *  Date format: standard; from year to millisecond
     */
    public static final DateFormat DATE_FORMAT_STANDARD_YEAR_TO_MILLIS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

    /**
     *  Date format: consecutive; from year to millisecond
     */
    public static final DateFormat DATE_FORMAT_CONSECUTIVE_YEAR_TO_MILLIS = new SimpleDateFormat("yyyyMMddHHmmssSSS");

    /**
     *  Privatize no-args constructor
     */
    private DateUtils() { }
}
