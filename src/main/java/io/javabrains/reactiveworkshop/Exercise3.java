package io.javabrains.reactiveworkshop;

import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.List;

public class Exercise3 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux()

        // Get all numbers in the ReactiveSources.intNumbersFlux stream
        // into a List and print the list and its size
        Mono<List<Integer>> listMono = ReactiveSources.intNumbersFlux().collectList();

        System.out.printf("%s", listMono.block());

//        System.out.println("Press a key to end");
//        System.in.read();
    }

}
