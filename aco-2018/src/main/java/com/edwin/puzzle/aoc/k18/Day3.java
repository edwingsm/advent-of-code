package com.edwin.puzzle.aoc.k18;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day3 {

    public static void main(String[] args) throws Exception {

        Path path = Paths.get(Day1.class.getClassLoader()
                .getResource("input/day31.txt").toURI());

        try (Stream<String> stream = Files.lines(path)) {

            List<String> list =stream.map(el ->{String s = (String)el;
                                s=s.replaceAll("[^\\d.]", ",");
                return s;}).collect(Collectors.toList());
            System.out.print(list.size());
            //https://www.baeldung.com/java-check-if-two-rectangles-overlap
        }
    }
}
