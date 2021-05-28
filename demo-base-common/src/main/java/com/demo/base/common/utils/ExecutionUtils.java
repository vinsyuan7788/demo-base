package com.demo.base.common.utils;

import com.demo.base.common.exception.utils.ExceptionUtils;
import com.demo.base.common.utils.utils.ParametersToLog;
import lombok.extern.slf4j.Slf4j;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 *  This class is used for execution utility
 *
 * @author Vince Yuan
 * @date 05/27/2021
 */
@Slf4j
public class ExecutionUtils {

    /**
     *  Privatize no-args constructor
     */
    private ExecutionUtils() { }

    /**
     *  Execute a function with exception process <br/>
     *  -- By default, an error message will be logged and the exception will be thrown if there is any exception occurred
     *
     * @param function the function to be executed
     * @param argument the argument of the function
     * @param runtimeException the runtime exception to be processed
     * @param <T> the type of parameter
     * @param <R> the type of result to be returned
     * @return the result returned from the function
     */
    public static <T, R> R executeWithExceptionProcess(Function<T, R> function, T argument, RuntimeException runtimeException) {
        try {
            return function.apply(argument);
        } catch (Exception e) {
            log.error(LogUtils.getLogMessage("executeWithExceptionProcess", "执行异常"), e);
            ExceptionUtils.throwRuntimeException(runtimeException);
            return null;
        }
    }

    /**
     *  Execute a function with exception process <br/>
     *  -- By default, an error message will be logged and the exception will be thrown if there is any exception occurred
     *
     * @param biFunction the function to be executed
     * @param argument1 the 1st argument of the function
     * @param argument2 the 2nd argument of the function
     * @param runtimeException the runtime exception to be processed
     * @param <T> the type of 1st parameter
     * @param <U> the type of 2nd parameter
     * @param <R> the type of result to be returned
     * @return the result returned from the function
     */
    public static <T, U, R> R executeWithExceptionProcess(BiFunction<T, U, R> biFunction, T argument1, U argument2, RuntimeException runtimeException) {
        try {
            return biFunction.apply(argument1, argument2);
        } catch (Exception e) {
            log.error(LogUtils.getLogMessage("executeWithExceptionProcess", "执行异常"), e);
            ExceptionUtils.throwRuntimeException(runtimeException);
            return null;
        }
    }
}
