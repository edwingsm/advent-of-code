package com.edwin.puzzle.aoc.k18;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Day1 {

    public static void main(String[] args) throws Exception {
        //    URL input = ClassLoader.getSystemResource("input/day1.txt");

        Path path = Paths.get(Day1.class.getClassLoader()
                .getResource("input/day1.txt").toURI());

        try (Stream<String> stream = Files.lines(path)) {
          System.out.println(  stream.mapToInt(Integer::new).sum());
           // System.out.println(stream.filter(niceStringPart1Rules).count());
        }

        List<Integer> cache = new ArrayList<>();
        cache.add(0);

        try (Stream<String> stream = Files.lines(path)) {

            List<Integer> integers =stream.mapToInt(Integer::new).boxed().collect(Collectors.toList());
            int sum=0;
            boolean found=false;
            do {
                for (Integer n : integers) {
                    sum = sum + n;
                    if (cache.contains(sum)) {
                        found=true;
                        System.out.print(sum);
                        break;
                    }
                    else
                        cache.add(sum);
                }
            }while (found==false);
        }

    }

}
