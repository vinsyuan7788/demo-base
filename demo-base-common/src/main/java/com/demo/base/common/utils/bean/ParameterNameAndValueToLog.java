package com.demo.base.common.utils.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 *  This model represents the key-value pair to be logged
 *
 * @author Vince Yuan
 * @date 05/27/2021
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ParameterNameAndValueToLog implements Serializable {

    /**
     *  The name of the parameter to be logged
     */
    private String name;

    /**
     *  The value of the parameter to be logged
     */
    private Object value;
}
