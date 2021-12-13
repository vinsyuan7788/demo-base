package com.demo.base.common.snowflake;

import com.demo.haima.client.Client;
import com.demo.haima.client.HaimaClient;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Vince Yuan
 * @date 2021/11/18
 */
@Slf4j
public class SnowflakeIdService implements IdService {

    private Client client;

    public SnowflakeIdService(String connectString, int clientTimeout) {
        try {
            client = new HaimaClient(connectString, clientTimeout);
        } catch (Exception e) {
            log.error("Get client error", e);
            throw new SnowFlakeException(e);
        }
    }

    @Override
    public long getLongSnowflakeId() {
        try {
            return client.getSnowFlakeId(0);
        } catch (Exception e) {
            log.error("Get snowflake ID error", e);
            throw new SnowFlakeException(e);
        }
    }
}
