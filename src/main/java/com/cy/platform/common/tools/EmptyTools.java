package com.cy.platform.common.tools;

import java.util.Collection;

/**
 * 判空工具类
 * @author 56807
 */
public class EmptyTools {
    /**
     * 判断集合是否为空
     *
     * @param collection 集合
     * @return TRUE/FALSE
     */
    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    /**
     * 判断集合不为空
     *
     * @param collection 集合
     * @return TRUE/FALSE
     */
    public static boolean isNotEmpty(Collection<?> collection) {
        return !isEmpty(collection);
    }

    private EmptyTools(){
        throw new UnsupportedOperationException();
    }
}
