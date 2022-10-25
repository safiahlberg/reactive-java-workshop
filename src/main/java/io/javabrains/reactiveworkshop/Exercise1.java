package io.javabrains.reactiveworkshop;

public class Exercise1 {

    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()

        System.out.printf("Ex1 part1%n");

        // Print all numbers in the intNumbersStream stream
        StreamSources.intNumbersStream().forEach(integer -> System.out.printf("%d%n", integer));

        System.out.printf("%nEx1 part2%n");

        // Print numbers from intNumbersStream that are less than 5
        StreamSources.intNumbersStream().filter(integer -> integer < 5)
                .forEach(integer -> System.out.printf("%d%n", integer));

        System.out.printf("%nEx1 part3%n");

        // Print the second and third numbers in intNumbersStream that's greater than 5
        StreamSources.intNumbersStream().filter(integer -> integer > 5)
                .skip(1)
                .limit(2)
                .forEach(integer -> System.out.printf("%d%n", integer));

        System.out.printf("%nEx1 part4%n");

        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
        StreamSources.intNumbersStream().filter(integer -> integer > 5)
                .findFirst()
                .ifPresentOrElse(integer -> System.out.printf("%d%n", integer),
                        () -> System.out.println("-1%n"));

        System.out.printf("%nEx1 part5%n");

        // Print first names of all users in userStream
        StreamSources.userStream().forEach(user -> System.out.printf("%s%n", user.getFirstName()));

        System.out.printf("%nEx1 part6%n");

        // Print first names in userStream for users that have IDs from number stream
        StreamSources.userStream()
                .filter(user -> StreamSources.intNumbersStream().anyMatch(integer -> integer == user.getId()))
                .forEach(user -> System.out.printf("%s%n", user.getFirstName()));

    }

}
