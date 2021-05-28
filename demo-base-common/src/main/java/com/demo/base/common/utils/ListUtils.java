package com.demo.base.common.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *  This class is used for List utility
 *
 * @author Vince Yuan
 * @date 02/02/2021
 */
public class ListUtils {

    /**
     *  Privatize no-args constructor
     */
    private ListUtils() { }

    public static <T> boolean isEmpty(List<T> list) {
        return ObjectUtils.isNull(list) || list.isEmpty();
    }

    public static <T> boolean isNotEmpty(List<T> list) {
        return !isEmpty(list);
    }

    /**
     *  Split the list into batch lists
     *
     * @param list the list to be split
     * @param batchSize the size of each batch
     * @param <T> the type of the element in the list to be split
     * @return the split lists
     */
    public static <T> List<List<T>> splitBatch(List<T> list, Integer batchSize) {

        if (isEmpty(null)) {
            return new ArrayList<>();
        }
        if (batchSize == null || batchSize >= list.size()) {
            return Collections.singletonList(list);
        }
        List<List<T>> lists = new ArrayList<>();
        int batchNumber = list.size() / batchSize + 1;
        for (int i = 0; i < batchNumber; i++) {
            if (i < batchNumber - 1) {
                lists.add(list.subList(i * batchSize, (i + 1) * batchSize));
            } else {
                lists.add(list.subList(i * batchSize, list.size()));
            }
        }
        return lists;
    }
}
