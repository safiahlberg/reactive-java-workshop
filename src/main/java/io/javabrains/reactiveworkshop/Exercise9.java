package io.javabrains.reactiveworkshop;

import java.io.IOException;

public class Exercise9 {


    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux()

        // Print size of intNumbersFlux after the last item returns
        /*ReactiveSources.intNumbersFlux()
                .count()
                .subscribe(num -> System.out.printf("Number of items: %d%n", num));*/

        // Collect all items of intNumbersFlux into a single list and print it
        /*ReactiveSources.intNumbersFlux()
                .collectList()
                .subscribe(intList -> System.out.printf("Items: %s%n", intList));*/

        // Transform to a sequence of sums of adjacent two numbers
        /*ReactiveSources.intNumbersFlux()
                .buffer(2)
                .filter(nums -> nums.size() == 2)
                .map(nums -> nums.get(0) + nums.get(1))
                .subscribe(num -> System.out.printf("Value: %d%n", num));*/

        // Transforma to a sequence of sums of adjacent two numbers, but only advance one step at the time
        ReactiveSources.intNumbersFlux()
                .zipWith(ReactiveSources.intNumbersFlux().skip(1))
                .map(tuple -> tuple.getT1() + tuple.getT2())
                .subscribe(num -> System.out.printf("Value: %d%n", num));

        System.out.println("Press a key to end");
        System.in.read();
    }

}
