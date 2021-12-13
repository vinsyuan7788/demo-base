package com.demo.base.common.snowflake;

/**
 * @author Vince Yuan
 * @date 2021/11/18
 */
public interface IdService {

    /**
     * This method is used to get a long-typed snowflake ID
     *
     * @return
     */
    long getLongSnowflakeId();
}
