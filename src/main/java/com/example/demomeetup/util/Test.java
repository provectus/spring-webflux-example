package com.example.demomeetup.util;

import reactor.core.publisher.Flux;

import java.util.stream.IntStream;

public class Test {

    public static void main(String[] args) {
        usualStream();
    }

    static void usualStream() {
        Flux.fromStream(IntStream.rangeClosed(1, 100).boxed())
                .filter(i -> i % 2 == 0)
                .map(i -> i * 2)
                .take(10)
                .subscribe(System.out::println);
    }

}
