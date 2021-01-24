package com.cy.platform.common.tools;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * lambda工具类
 *
 * @author develop
 */
public class LambdaTools {

    /**
     * 工具：提前集合对象属性生成新的集合
     * @param source 集合对象
     * @param mapper 映射关系
     * @param <R> R
     * @param <U> U
     * @return 属性集合
     */
    public static <R, U> List<R> extractList(Collection<U> source, Function<? super U, ? extends R> mapper) {
        if (EmptyTools.isEmpty(source)) {
            return new ArrayList<>();
        }
        return source.stream().map(mapper).collect(Collectors.toList());
    }

    /**
     * 工具：提前集合对象属性生成新的集合
     * @param source 集合对象
     * @param mapper 映射关系
     * @param predicate 过滤条件
     * @param <R> R
     * @param <U> U
     * @return 属性集合
     */
    public static <R, U> List<R> extractList(
            Collection<U> source,
            Function<? super U, ? extends R> mapper,
            Predicate<? super U> predicate) {
        if (EmptyTools.isEmpty(source)) {
            return new ArrayList<>();
        }
        return source.stream().filter(predicate).map(mapper).collect(Collectors.toList());
    }


    private LambdaTools() {
        throw new UnsupportedOperationException();
    }
}
