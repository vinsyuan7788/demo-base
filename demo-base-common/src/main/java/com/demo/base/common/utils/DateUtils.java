package com.demo.base.common.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * @author Vince Yuan
 * @date 02/02/2021
 */
public class DateUtils {

    /**
     *  日期格式：标准，从年到秒
     */
    public static final DateFormat DATE_FORMAT_STANDARD_YEAR_TO_SECOND = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     *  日期格式：连续，从年到毫秒
     */
    public static final DateFormat DATE_FORMAT_CONSECUTIVE_YEAR_TO_MILLIS = new SimpleDateFormat("yyyyMMddHHmmssSSS");

    /**
     *  Privatize no-args constructor
     */
    private DateUtils() { }
}
