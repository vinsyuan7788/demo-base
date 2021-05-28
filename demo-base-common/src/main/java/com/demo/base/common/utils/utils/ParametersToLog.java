package com.demo.base.common.utils.utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *  This model is used to store the parameters to log
 *
 * @author Vince Yuan
 * @date 05/27/2021
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParametersToLog implements Serializable {

    /**
     *  The names and values of the parameters to be logged
     */
    private List<ParameterNameAndValueToLog> parameterNamesAndValues = new ArrayList<>();

    /**
     *  Add the parameter to log
     *
     * @param name the name of the parameter to be logged
     * @param value the value of the parameter
     * @return the ParametersToLog instance itself
     */
    public ParametersToLog addParameter(String name, Object value) {
        parameterNamesAndValues.add(ParameterNameAndValueToLog.builder().name(name).value(value).build());
        return this;
    }
}
