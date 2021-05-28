package com.demo.base.common.utils;

import java.util.Map;

/**
 *  This class is used for Map utility
 *
 * @author Vince Yuan
 * @date 02/02/2021
 */
public class MapUtils {

    /**
     *  Privatize no-args constructor
     */
    private MapUtils() { }

    /**
     *  Predicate if a map is empty
     *
     * @param map the map to be predicated
     * @return if the map is empty
     */
    public static <K, V> boolean isEmpty(Map<K, V> map) {
        return ObjectUtils.isNull(map) || map.isEmpty();
    }

    /**
     *  Predicate if a map is NOT empty
     *
     * @param map the map to be predicated
     * @return if the map is NOT empty
     */
    public static <K, V> boolean isNotEmpty(Map<K, V> map) {
        return !isEmpty(map);
    }
}
