package com.oca.exam.extra.features.parallel.streams;

import com.oca.exam.extra.features.common.FuturamaCharacter;

import java.util.Arrays;
import java.util.List;

public class ReductionExample {

    public static void main(String... args) {

        List<FuturamaCharacter> characters = Arrays.asList(
                new FuturamaCharacter("Bender", "Rodriguez", 5),
                new FuturamaCharacter("Philip", "Fry", 126),
                new FuturamaCharacter("Turanga", "Leela", 22));

        System.out.println("Futurama characters:");
        characters.forEach(c -> System.out.println(c));

        int sumAge = characters
                .stream()
                .parallel()
                .mapToInt(FuturamaCharacter::getAge)
                .sum();
        System.out.println("\nSum of ages: " + sumAge);

        int sumAgeReduce = characters
                .stream()
                .parallel()
                .map(FuturamaCharacter::getAge)
                .reduce(0, (a, b) -> a + b);
        System.out.println("\nSum of ages with reduce: " + sumAgeReduce);
    }
}
