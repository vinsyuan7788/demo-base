package com.demo.base.common.utils;

import com.demo.base.common.utils.utils.ParameterNameAndValueToLog;
import com.demo.base.common.utils.utils.ParametersToLog;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 *  This class is used for Log utility
 *
 * @author Vince Yuan
 * @date 05/27/2021
 */
@Slf4j
public class LogUtils {

    /**
     *  The prefix of message log
     */
    public static final String MESSAGE_LOG_PREFIX = "=== ";

    /**
     *  The suffix of message log
     */
    public static final String MESSAGE_LOG_SUFFIX = " ===";

    /**
     *  The separator of message log
     */
    public static final String MESSAGE_LOG_SEPARATOR = " | ";

    /**
     *  The separator of parameter name and value to log
     */
    public static final String PARAMETER_NAME_AND_VALUE_LOG_SEPARATOR = ": ";

    /**
     *  The message for blank log
     */
    private static final String BLANK_LOG_MESSAGE = "Necessary parameters are empty, hence blank log is returned";

    /**
     *  Privatize no-args constructor
     */
    private LogUtils() { }

    /**
     *  Get a log message
     *
     * @param message the message to be logged
     * @return the log message
     */
    public static String getLogMessage(String message) {
        return getLogMessage(null, message, null);
    }

    /**
     *  Get a log message with parameters
     *
     * @param methodNameOrMessage the method name or the message to be logged
     * @param parameters the parameters to be logged, where name is the name for the parameter to be logged and value is the value of the parameter
     * @param isMethodName if the first argument represents method name
     * @return the log message
     */
    public static String getLogMessage(String methodNameOrMessage, ParametersToLog parameters, boolean isMethodName) {
        return isMethodName ? getLogMessage(methodNameOrMessage, null, parameters) : getLogMessage(null, methodNameOrMessage, parameters);
    }

    /**
     *  Get a log message with parameters within a method
     *
     * @param methodName the name of the method to log message
     * @param message the message to be logged
     * @return the log message
     */
    public static String getLogMessage(String methodName, String message) {
        return getLogMessage(methodName, message, null);
    }

    /**
     *  Get a log message with parameters within a method
     *
     * @param methodName the name of the method to log message
     * @param message the message to be logged
     * @param parameters the parameters to be logged, where name is the name for the parameter to be logged and value is the value of the parameter
     * @return the log message
     */
    public static String getLogMessage(String methodName, String message, ParametersToLog parameters) {
        if (!messageCanBeLogged(methodName, message)) {
            log.info(getLogMessage("getLog", BLANK_LOG_MESSAGE, parameters));
            return StringUtils.BLANK_STRING;
        }
        StringBuilder log = new StringBuilder();
        log.append(MESSAGE_LOG_PREFIX);
        if (StringUtils.isNotBlank(methodName)) {
            log.append(methodName);
        }
        if (StringUtils.isNotBlank(message)) {
            if (StringUtils.isNotBlank(methodName)) {
                log.append(MESSAGE_LOG_SEPARATOR);
            }
            log.append(message);
        }
        if (ObjectUtils.isNotNull(parameters)) {
            if (methodNameOrMessageExists(methodName, message)) {
                log.append(MESSAGE_LOG_SEPARATOR);
            }
            log.append(getParameterLog(parameters));
        }
        log.append(MESSAGE_LOG_SUFFIX);
        return log.toString();
    }

    /**
     *  Predicate if the message can be logged
     *
     * @param methodName the name of the method to log message
     * @param message the message to be logged
     * @return if message can be logged
     */
    private static boolean messageCanBeLogged(String methodName, String message) {
        if (StringUtils.isNotBlank(methodName) && StringUtils.isNotBlank(message)) {
            return true;
        } else if (StringUtils.isNotBlank(methodName) && StringUtils.isBlank(message)) {
            return true;
        } else if (StringUtils.isBlank(methodName) && StringUtils.isNotBlank(message)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     *  Predicate if method name or message exists
     *
     * @param methodName the name of the method to log message
     * @param message the message to be logged
     * @return if method name or message exists
     */
    private static boolean methodNameOrMessageExists(String methodName, String message) {
        return StringUtils.isNotBlank(methodName) || StringUtils.isNotBlank(message);
    }

    /**
     *  Get parameter log
     *
     * @param parameters
     * @return
     */
    private static String getParameterLog(ParametersToLog parameters) {
        if (ObjectUtils.isNull(parameters)) {
            log.info(getLogMessage("getParameterLog", BLANK_LOG_MESSAGE, parameters));
            return StringUtils.BLANK_STRING;
        }
        StringBuilder log = new StringBuilder();
        List<ParameterNameAndValueToLog> parameterNamesAndValuesToLog = parameters.getParameterNamesAndValues();
        for (int i = 0; i < parameterNamesAndValuesToLog.size(); i++) {
            ParameterNameAndValueToLog parameterNameAndValueToLog = parameterNamesAndValuesToLog.get(i);
            log.append(parameterNameAndValueToLog.getName() + PARAMETER_NAME_AND_VALUE_LOG_SEPARATOR + parameterNameAndValueToLog.getValue());
            if (i < parameterNamesAndValuesToLog.size() - 1) {
                log.append(MESSAGE_LOG_SEPARATOR);
            }
        }
        return log.toString();
    }
}
