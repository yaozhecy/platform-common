package com.cy.platform.common.tools;

import com.cy.platform.common.exception.MessageException;

import java.util.*;

/**
 * 集合工具类
 *
 * @author develop
 */
public class CollectionTools {
    /**
     * MAX_POWER_OF_TWO
     */
    private static final int MAX_POWER_OF_TWO = 1 << (Integer.SIZE - 2);

    /**
     * 创建ArrayList
     *
     * @param size  初始大小
     * @param param 参数
     * @param <R>   R
     * @return 集合
     */
    public static <R> List<R> newArrayList(int size, R... param) {
        List<R> data = new ArrayList<>(Math.max(size, param.length));
        data.addAll(Arrays.asList(param));
        return data;
    }

    /**
     * 创建HashMap
     *
     * @param size 初始大小
     * @param <R>  R
     * @param <U>  U
     * @return Map
     */
    public static <R, U> Map<R, U> newHashMap(int size) {
        return new HashMap<>(capacity(size));
    }

    /**
     * 计算HashSet与HashMap大小
     *
     * @param expectedSize 期望大小
     * @return 实际大小
     */
    public static int capacity(int expectedSize) {
        final int minSize = 3;
        if (expectedSize < minSize) {
            if (expectedSize < 0) {
                throw new MessageException("期望大小不合法");
            }
            return expectedSize + 1;
        }
        if (expectedSize < MAX_POWER_OF_TWO) {
            return (int) ((float) expectedSize / 0.75F + 1.0F);
        }
        return Integer.MAX_VALUE;
    }

    private CollectionTools() {
        throw new UnsupportedOperationException();
    }
}
