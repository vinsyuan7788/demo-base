package com.demo.base.common.utils;

import com.demo.base.common.exception.base.BaseException;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author Vince Yuan
 * @date 04/11/2021
 */
public class IPUtils {

    /**
     *  Privatize no-args constructor
     */
    private IPUtils() { }

    /**
     *  Get the address of local host
     *
     * @return
     */
    public static String getLocalHostAddress() {
        try {
            InetAddress localHost = InetAddress.getLocalHost();
            if (localHost == null) {
                throw new BaseException("Local host is not found");
            }
            return localHost.getHostAddress();
        } catch (UnknownHostException uhe) {
            throw new BaseException("Unknown local host is found", uhe);
        }
    }

    /**
     *  Get the name of local host
     *
     * @return
     */
    public static String getLocalHostName() {
        try {
            InetAddress localHost = InetAddress.getLocalHost();
            if (localHost == null) {
                throw new BaseException("Local host is not found");
            }
            return localHost.getHostName();
        } catch (UnknownHostException uhe) {
            throw new BaseException("Unknown local host is found", uhe);
        }
    }
}
