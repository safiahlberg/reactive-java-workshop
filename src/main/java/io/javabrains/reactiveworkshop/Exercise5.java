package io.javabrains.reactiveworkshop;

import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;

import java.io.IOException;

public class Exercise5 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux() and ReactiveSources.userMono()

        // Subscribe to a flux using the error and completion hooks
//        ReactiveSources.intNumbersFlux().subscribe(
//                intNumber -> System.out.printf("Intnumber: %d%n", intNumber),
//                error -> System.out.printf("Error: %s", error.getMessage()),
//                () -> System.out.println("Processing complete."));

        // Subscribe to a flux using an implementation of BaseSubscriber
        ReactiveSources.intNumbersFlux().subscribe(new MySubscriber<>());

        System.out.println("Press a key to end");
        System.in.read();
    }
}

class MySubscriber<T> extends BaseSubscriber<T> {

    @Override
    protected void hookOnSubscribe(Subscription subscription) {
        System.out.println("Subscription started.");
        request(2);
    }

    @Override
    protected void hookOnNext(T value) {
        System.out.printf("Value: %s%n", value);
        request(2);
    }

    @Override
    protected void hookOnComplete() {
        System.out.println("Complete.");
    }

    @Override
    protected void hookOnError(Throwable throwable) {
        System.out.printf("Error: %s%n", throwable.getMessage());
    }
}