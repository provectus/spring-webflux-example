package com.example.demomeetup;

import lombok.SneakyThrows;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.stream.IntStream;

public class Test {

    @SneakyThrows
    public static void main(String[] args) {
        subscribeOnStream();
        Thread.sleep(500);

        //publishOnStream();
    }

    static void subscribeOnStream() {
        Flux.fromStream(IntStream.rangeClosed(1, 100).boxed())
                .filter(i -> {
                    System.out.println("Filter thread: " + Thread.currentThread().getName());
                    return i % 2 == 0;
                })
                .map(i -> {
                    System.out.println("Map thread: " + Thread.currentThread().getName());
                    return i * 2;
                })
                .take(10)
                .subscribeOn(Schedulers.boundedElastic())
                .subscribe(System.out::println);
    }

    static void publishOnStream() {
        Flux.fromStream(IntStream.rangeClosed(1, 100).boxed())
                .filter(i -> {
                    System.out.println("Filter thread: " + Thread.currentThread().getName());
                    return i % 2 == 0;
                })
                .publishOn(Schedulers.boundedElastic())
                .map(i -> {
                    System.out.println("Map thread: " + Thread.currentThread().getName());
                    return i * 2;
                })
                .take(10)
                .subscribe(System.out::println);
    }
}
