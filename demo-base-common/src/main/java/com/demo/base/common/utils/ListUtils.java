package com.demo.base.common.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Vince Yuan
 * @date 02/02/2021
 */
public class ListUtils {

    /**
     *  Privatize no-args constructor
     */
    private ListUtils() { }

    /**
     *  Split the list into batch lists
     *
     * @param list
     * @param batchSize
     * @param <T>
     * @return
     */
    public static <T> List<List<T>> splitBatch(List<T> list, Integer batchSize) {
        if (list == null) {
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
