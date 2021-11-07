package com.demo.base.common.utils;

import com.demo.base.common.utils.bean.ParameterNameAndValueToLog;
import com.demo.base.common.utils.bean.ParametersToLog;
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
     *  The message for null parameters
     */
    private static final String NULL_PARAMETERS_MESSAGE = "Parameters to log are null, hence blank log message is returned";

    /**
     *  The message for null parameter value
     */
    private static final String NULL_PARAMETER_VALUE_MESSAGE = "Parameter value is null, hence do not need to get log message for it";

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
     *  Log the parameters
     *
     * @param parameters the parameters to be logged, where name is the name for the parameter to be logged and value is the value of the parameter
     * @return the logged parameters
     */
    public static String getLogMessage(ParametersToLog parameters) {
        return getLogMessage(null, null, parameters);
    }

    /**
     *  Get a log message with parameters
     *
     * @param methodNameOrMessage the method name or the message to be logged
     * @param parameters the parameters to be logged, where name is the name for the parameter to be logged and value is the value of the parameter
     * @return the log message
     */
    public static String getLogMessage(String methodNameOrMessage, ParametersToLog parameters) {
        return isMethodName(methodNameOrMessage) ? getLogMessage(methodNameOrMessage, null, parameters) : getLogMessage(null, methodNameOrMessage, parameters);
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
        StringBuilder logMessage = new StringBuilder();
        logMessage.append(MESSAGE_LOG_PREFIX);
        if (StringUtils.isNotBlank(methodName)) {
            logMessage.append(methodName);
        }
        if (StringUtils.isNotBlank(message)) {
            if (StringUtils.isNotBlank(methodName)) {
                logMessage.append(MESSAGE_LOG_SEPARATOR);
            }
            logMessage.append(message);
        }
        if (ObjectUtils.isNotNull(parameters)) {
            if (methodNameOrMessageExists(methodName, message)) {
                logMessage.append(MESSAGE_LOG_SEPARATOR);
            }
            logMessage.append(getParameterLog(parameters));
        }
        logMessage.append(MESSAGE_LOG_SUFFIX);
        return logMessage.toString();
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
            log.info(getLogMessage("getParameterLog", NULL_PARAMETERS_MESSAGE));
            return StringUtils.BLANK_STRING;
        }
        StringBuilder logMessage = new StringBuilder();
        List<ParameterNameAndValueToLog> parameterNamesAndValuesToLog = parameters.getParameterNamesAndValues();
        for (int i = 0; i < parameterNamesAndValuesToLog.size(); i++) {
            ParameterNameAndValueToLog parameterNameAndValueToLog = parameterNamesAndValuesToLog.get(i);
            String parameterName = parameterNameAndValueToLog.getName();
            Object parameterValue = parameterNameAndValueToLog.getValue();
            if (StringUtils.isNotBlank(parameterName) && ObjectUtils.isNotNull(parameterValue)) {
                logMessage.append(parameterName + PARAMETER_NAME_AND_VALUE_LOG_SEPARATOR + parameterNameAndValueToLog.getValue());
            } else if (StringUtils.isBlank(parameterName) && ObjectUtils.isNotNull(parameterValue)) {
                logMessage.append(parameterNameAndValueToLog.getValue());
            } else {
                log.info(getLogMessage("getParameterLog", NULL_PARAMETER_VALUE_MESSAGE));
                continue;
            }
            if (i < parameterNamesAndValuesToLog.size() - 1) {
                logMessage.append(MESSAGE_LOG_SEPARATOR);
            }
        }
        return logMessage.toString();
    }

    /**
     *  Predicate if the string is method name or message
     *
     * @param methodNameOrMessage the method name or the message to be logged
     * @return if the input string is method name
     */
    private static boolean isMethodName(String methodNameOrMessage) {
        /**
         *  Since the format of log message with method name only and the one with message only are the same
         *  -- Here do not need to distinguish method name and message to log the message
         *  -- Simply to say, true can be always returned
         */
        return true;
    }
}
