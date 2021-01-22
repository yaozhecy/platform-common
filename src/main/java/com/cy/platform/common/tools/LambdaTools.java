package com.cy.platform.common.tools;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * lambda工具类
 *
 * @author develop
 */
public class LambdaTools {

    /**
     *
     * @param source
     * @param mapper
     * @param <R>
     * @param <U>
     * @return
     */
    public static <R, U> List<R> extractList(List<U> source, Function<? super U, ? extends R> mapper) {
        if (CollectionTools.isEmpty(source)) {
            return new ArrayList<>();
        }
        return source.stream().map(mapper).collect(Collectors.toList());
    }

    private LambdaTools() {
        throw new UnsupportedOperationException();
    }
}
