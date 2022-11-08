package io.javabrains.reactiveworkshop;

import reactor.core.publisher.Flux;

import java.io.IOException;

public class Exercise8 {


    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFluxWithException()

        // Print values from intNumbersFluxWithException and print a message when error happens
        /*ReactiveSources.intNumbersFluxWithException()
//                .doOnError(throwable -> System.out.printf("Error: %s%n", throwable.getMessage()))
                .subscribe(num -> System.out.printf("Value: %d%n", num),
                        err -> System.out.printf("Error: %s%n", err.getMessage()));*/

        // Print values from intNumbersFluxWithException and continue on errors
        /*ReactiveSources.intNumbersFluxWithException()
                .onErrorContinue((err, num) -> System.out.printf("Error: %s, for value: %d%n", err.getMessage(), num))
                .subscribe(num -> System.out.printf("Value: %s%n", num));*/

        // Print values from intNumbersFluxWithException and when errors
        // happen, replace with a fallback sequence of -1 and -2
        ReactiveSources.intNumbersFluxWithException()
                .onErrorResume(err -> Flux.just(-1, -2))
                .subscribe(num -> System.out.printf("Value: %d%n", num));

        System.out.println("Press a key to end");
        System.in.read();
    }

}
