package com.edwin.puzzle.aoc.k15;

/**
 * --- Day 5: Doesn't He Have Intern-Elves For This? ---
 * Santa needs help figuring out which strings in his text file are naughty or nice.
 * <p/>
 * A nice string is one with all of the following properties:
 * -    It contains at least three vowels (aeiou only), like aei, xazegov, or aeiouaeiouaeiou.
 * -    It contains at least one letter that appears twice in a row, like xx, abcdde (dd), or aabbccdd (aa, bb, cc, or dd).
 * -    It does not contain the strings ab, cd, pq, or xy, even if they are part of one of the other requirements.
 * <p/>
 * --- Part Two ---
 * Realizing the error of his ways, Santa has switched to a better model of determining whether a string is naughty or
 * nice. None of the old rules apply, as they are all clearly ridiculous.
 * <p/>
 * Now, a nice string is one with all of the following properties:
 * -    It contains a pair of any two letters that appears at least twice in the string without overlapping,
 * -        like xyxy (xy) or aabcdefgaa (aa), but not like aaa (aa, but it overlaps).
 * -    It contains at least one letter which repeats with exactly one letter between them, like xyx, abcdefeghi (efe),
 * -        or even aaa.
 */

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Day5 {

    private static final Pattern VOWELS = Pattern.compile("([aeiou])\\w*([aeiou])\\w*([aeiou])");
    private static final Pattern DUPLICATES = Pattern.compile("(\\w)\\1+");
    private static final Pattern BANNED = Pattern.compile("(ab)|(cd)|(pq)|(xy)");
    private static final Pattern DUPLICATE_NON_OVERLAP = Pattern.compile("(\\w)(\\w)(\\w*)\\1\\2+");
    private static final Pattern REPEAT_WITH_GAP = Pattern.compile("(\\w)(\\w)\\1+");

    public static Predicate<String> containsAtLeastThreeVowels = (str) -> {
        Matcher matcher = VOWELS.matcher(str);
        return (matcher.find());
    };

  //  private static final Pattern containsRepeatingLettersPattern = Pattern.compile("(.)\\1");

    public static Predicate<String> containsRepeatingLetters = (str) -> {
        Matcher matcher = DUPLICATES.matcher(str);
        return matcher.find();
    };

  //  private static final Pattern doesNotContainAbCdPqXyPattern = Pattern.compile("(ab|cd|pq|xy)");

    public static Predicate<String> doesNotContainAbCdPqXy = (str) -> {
        Matcher matcher = BANNED.matcher(str);
        return (!matcher.find());
    };

    public static Predicate<String> niceStringPart1Rules = (str) -> {
        return containsAtLeastThreeVowels.and(containsRepeatingLetters).and(doesNotContainAbCdPqXy).test(str);
    };

   // private static final Pattern containsRepeatingPairOfLettersPattern = Pattern.compile("((.)(.)).*\\1");

    public static Predicate<String> containsRepeatingPairOfLetters = (str) -> {
        Matcher matcher = DUPLICATE_NON_OVERLAP.matcher(str);
        return matcher.find();
    };

  //  private static final Pattern containsRepeatingLettersWithAnotherInBetweenPattern = Pattern.compile("(.).\\1");

    public static Predicate<String> containsRepeatingLettersWithAnotherInBetween = (str) -> {
        Matcher matcher = REPEAT_WITH_GAP.matcher(str);
        return matcher.find();
    };

    public static Predicate<String> niceStringPart2Rules = (str) -> {
        return containsRepeatingPairOfLetters.and(containsRepeatingLettersWithAnotherInBetween).test(str);
    };

    public static void main(String[] args) throws Exception {
    //    URL input = ClassLoader.getSystemResource("input/day3.txt");

        Path path = Paths.get(Day5.class.getClassLoader()
                .getResource("input/day3.txt").toURI());

        try (Stream<String> stream = Files.lines(path)) {
            System.out.println(stream.filter(niceStringPart1Rules).count());
        }

        try (Stream<String> stream = Files.lines(path)) {
            System.out.println(stream.filter(niceStringPart2Rules).count());
        }
//            long numOfNiceStrings =  //
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
