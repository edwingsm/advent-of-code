package com.edwin.puzzle.aoc.k15;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Day52 {
    private static final Pattern containsAtLeastThreeVowelsPattern = Pattern.compile("[aeiou].*[aeiou].*[aeiou]");

    public static Predicate<String> containsAtLeastThreeVowels = (str) -> {
        Matcher matcher = containsAtLeastThreeVowelsPattern.matcher(str);
        return (matcher.find());
    };

    private static final Pattern containsRepeatingLettersPattern = Pattern.compile("(.)\\1");

    public static Predicate<String> containsRepeatingLetters = (str) -> {
        Matcher matcher = containsRepeatingLettersPattern.matcher(str);
        return matcher.find();
    };

    private static final Pattern doesNotContainAbCdPqXyPattern = Pattern.compile("(ab|cd|pq|xy)");

    public static Predicate<String> doesNotContainAbCdPqXy = (str) -> {
        Matcher matcher = doesNotContainAbCdPqXyPattern.matcher(str);
        return !(matcher.find());
    };

    public static Predicate<String> niceStringPart1Rules = (str) -> {
        return containsAtLeastThreeVowels.and(containsRepeatingLetters).and(doesNotContainAbCdPqXy).test(str);
    };

    private static final Pattern containsRepeatingPairOfLettersPattern = Pattern.compile("((.)(.)).*\\1");

    public static Predicate<String> containsRepeatingPairOfLetters = (str) -> {
        Matcher matcher = containsRepeatingPairOfLettersPattern.matcher(str);
        return matcher.find();
    };

    private static final Pattern containsRepeatingLettersWithAnotherInBetweenPattern = Pattern.compile("(.).\\1");

    public static Predicate<String> containsRepeatingLettersWithAnotherInBetween = (str) -> {
        Matcher matcher = containsRepeatingLettersWithAnotherInBetweenPattern.matcher(str);
        return matcher.find();
    };

    public static Predicate<String> niceStringPart2Rules = (str) -> {
        return containsRepeatingPairOfLetters.and(containsRepeatingLettersWithAnotherInBetween).test(str);
    };

    public static void main(String[] args) throws Exception{
        Path path = Paths.get(Day52.class.getClassLoader()
                .getResource("input/day3.txt").toURI());
        try (Stream<String> stream = Files.lines(path)) {
            System.out.println(stream.filter(niceStringPart1Rules).count());
        }

        try (Stream<String> stream = Files.lines(path)){
            System.out.println(stream.filter(niceStringPart2Rules).count());
        }
//        long numOfNiceStrings = InputProcessor.readFile("files/day5-input.txt") //
//                .filter(niceStringPart1Rules) //
//                .count();
//        System.out.println("Number of nice strings according to part 1 rules: " + numOfNiceStrings);
//
//        long numOfActualNiceStrings = InputProcessor.readFile("files/day5-input.txt") //
//                .filter(niceStringPart2Rules) //
//                .count();
//        System.out.println("Number of nice strings according to part 2 rules: " + numOfActualNiceStrings);

    }
}
