package com.edwin.puzzle.aoc.k18;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Day2 {

    public static void main(String[] args) throws Exception{

//        Path path = Paths.get(Day1.class.getClassLoader()
//                .getResource("input/day2.txt").toURI());
//
//        try (Stream<String> stream = Files.lines(path)) {
//
//        }



        List<String> strings = Arrays.asList("abcdef","bababc","abbcde","abcccd","aabcdd","abcdee","ababab");
//^(?:(.)(?!\1|(?:.*?\1){2}))*\z https://stackoverflow.com/questions/6929614/regex-repeated-character-count
        int twocount=0,threecount=0;
       // for (String s: strings) {
       //     s
       // }

        String stringToMatch = "abccdefeeeef";
        Pattern p =Pattern.compile("(.).*\\1");//Pattern.compile("(\\w)\\1+"); //(.).*\1
        Matcher m = p.matcher(stringToMatch);
        while (m.find())
        {
            System.out.println("Duplicate character " + m.group(1));
        }

    }
}
