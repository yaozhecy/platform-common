package com.cy.platform.common.tools;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.concurrent.atomic.AtomicInteger;

public class CollectionToolsTest {

    @Test
    public void newArrayList() {
        AtomicInteger sum = new AtomicInteger(0);
        Flux.just(1, 2, 3, 4)  .subscribeOn(Schedulers.elastic()).reduce(Integer::sum).subscribe(sum::set);
        System.out.println(sum.get());
    }
}