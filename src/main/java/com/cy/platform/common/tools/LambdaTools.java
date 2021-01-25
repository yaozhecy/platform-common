package com.cy.platform.common.tools;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * lambda工具类
 *
 * @author develop
 */
public class LambdaTools {
    /**
     * 工具：提前集合对象属性生成新的集合
     *
     * @param source 集合对象
     * @param mapper 映射关系
     * @param <R>    R
     * @param <U>    U
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
     *
     * @param source    集合对象
     * @param mapper    映射关系
     * @param predicate 过滤条件
     * @param <R>       R
     * @param <U>       U
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

    /**
     * 工具：根据对象属性分组
     *
     * @param source 集合对象
     * @param mapper 映射关系
     * @param <R>    R
     * @param <U>    U
     * @return 分组后集合
     */
    public static <R, U> Map<R, List<U>> extractMap(
            Collection<U> source,
            Function<? super U, ? extends R> mapper) {
        if (EmptyTools.isEmpty(source)) {
            return CollectionTools.newHashMap(0);
        }
        return source.stream().collect(Collectors.groupingBy(mapper));
    }

    /**
     * 工具：将list转换成Map
     *
     * @param source 数据集合
     * @param mapper 映射关系
     * @param <R>    R
     * @param <U>    U
     * @return 集合
     */
    public static <R, U> Map<R, U> listToMap(
            Collection<U> source,
            Function<? super U, ? extends R> mapper) {
        if (EmptyTools.isEmpty(source)) {
            return CollectionTools.newHashMap(0);
        }
        return source.stream().collect(Collectors.toMap(mapper, n -> n));
    }

    /**
     * 工具：集合扁平
     *
     * @param s1  数据集合1
     * @param s2  数据集合2
     * @param <U> U
     * @return 数据
     */
    public static <U> List<U> flatMap(Collection<U> s1, Collection<U> s2) {
        return Stream.of(s1, s2).flatMap(Collection::stream).collect(Collectors.toList());
    }

    private LambdaTools() {
        throw new UnsupportedOperationException();
    }
}
