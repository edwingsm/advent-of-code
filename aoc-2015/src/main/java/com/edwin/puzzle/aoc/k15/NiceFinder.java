package com.edwin.puzzle.aoc.k15;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class NiceFinder {

        private static final Pattern VOWELS = Pattern.compile("([aeiou])\\w*([aeiou])\\w*([aeiou])");
        private static final Pattern DUPLICATES = Pattern.compile("(\\w)\\1+");
        private static final Pattern BANNED = Pattern.compile("(ab)|(cd)|(pq)|(xy)");
        private static final Pattern DUPLICATE_NON_OVERLAP = Pattern.compile("(\\w)(\\w)(\\w*)\\1\\2+");
        private static final Pattern REPEAT_WITH_GAP = Pattern.compile("(\\w)(\\w)\\1+");

        public static void main(String[] args) throws FileNotFoundException {
            URL input = ClassLoader.getSystemResource("input/day5.txt");

            int niceLines = findCountOfNiceStrings(new BufferedReader(new FileReader(input.getPath())), false);
            System.out.println("We found " + niceLines + " nice Strings.");
            int actualNiceLines = findCountOfNiceStrings(new BufferedReader(new FileReader(input.getPath())), true);


            System.out.print("Using the improved formula, there are actually " + actualNiceLines + " nice Strings.");
        }

        private static int findCountOfNiceStrings(BufferedReader reader, boolean useImprovedFormuala) {
            List<String> niceStrings = new ArrayList<>();
            reader.lines().forEach(line -> {
                boolean nice = useImprovedFormuala ? isActuallyNice(line) : isNice(line);
                if (nice) {
                    System.out.println(line);
                    niceStrings.add(line);
                }
            });
            return niceStrings.size();
        }

        static boolean isNice(String test) {
            boolean hasVowels = VOWELS.matcher(test).find();
            boolean hasDuplicates = DUPLICATES.matcher(test).find();
            boolean isBanned = BANNED.matcher(test).find();
            return hasVowels && hasDuplicates && !isBanned;
        }

        static boolean isActuallyNice(String test) {
            boolean hasNonOverlappingDuplicates = DUPLICATE_NON_OVERLAP.matcher(test).find();
            boolean hasRepeatedCharactersWithGap = REPEAT_WITH_GAP.matcher(test).find();
            return hasNonOverlappingDuplicates && hasRepeatedCharactersWithGap;
        }

}
