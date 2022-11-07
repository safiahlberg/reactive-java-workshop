package io.javabrains.reactiveworkshop;

import java.io.IOException;

public class Exercise4 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono()

        // Print the value from intNumberMono when it emits
        System.out.println("Fetching from Mono...");
        // System.out.printf("Value from intNumberMono(): %s%n", ReactiveSources.intNumberMono().block());
        ReactiveSources.intNumberMono()
                .subscribe(intNumber -> System.out.printf("Value from intNumberMono(): %s%n", intNumber));

        // Get the value from the Mono into an integer variable
        int intNumber = ReactiveSources.intNumberMono().blockOptional().orElse(-1);
        System.out.printf("intNumber: %d%n", intNumber);


//        System.out.println("Press a key to end");
//        System.in.read();
    }

}
