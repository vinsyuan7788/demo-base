package com.demo.base.common.exception.utils;

/**
 *  This class is used for exception utility
 *
 * @author Vince Yuan
 * @date 05/27/2021
 */
public class ExceptionUtils {

    /**
     *  Privatize no-args constructor
     */
    private ExceptionUtils() { }

    /**
     *  Throw runtime exception if there is any
     *  
     * @param runtimeException the (sub-class of) runtime exception to be thrown
     */
    public static void throwRuntimeException(RuntimeException runtimeException) {
        if (runtimeException != null) {
            throw runtimeException;
        }
    }
}
