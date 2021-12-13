package com.demo.base.snowflake;

import com.demo.haima.client.Client;
import com.demo.haima.client.HaimaClient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Vince Yuan
 * @date 2021/11/18
 */
public class SnowflakeIdService implements IdService {

    private static final Logger LOG = LoggerFactory.getLogger(SnowflakeIdService.class);

    private Client client;

    public SnowflakeIdService(String connectString, int clientTimeout) {
        try {
            client = new HaimaClient(connectString, clientTimeout);
        } catch (Exception e) {
            LOG.error("Get client error", e);
            throw new SnowFlakeException(e);
        }
    }

    @Override
    public long getLongSnowflakeId() {
        try {
            return client.getSnowFlakeId(0);
        } catch (Exception e) {
            LOG.error("Get snowflake ID error", e);
            throw new SnowFlakeException(e);
        }
    }
}
