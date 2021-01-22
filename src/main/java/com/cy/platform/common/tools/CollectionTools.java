package com.cy.platform.common.tools;

import java.util.Collection;

/**
 * 集合工具类
 *
 * @author develop
 */
public class CollectionTools {

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

    private CollectionTools() {
        throw new UnsupportedOperationException();
    }
}
