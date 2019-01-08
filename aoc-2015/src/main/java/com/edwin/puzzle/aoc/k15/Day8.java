package com.edwin.puzzle.aoc.k15;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Day8 {


    public static void main(String[] args) throws Exception{
        Path path = Paths.get(Day6.class.getClassLoader()
                .getResource("input/day8.txt").toURI());
        Supplier<Stream<String>> streamSupplier = () -> {
            try {
                return Files.lines(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return Stream.empty();
        };
        int memoryLength  =streamSupplier.get().mapToInt(s->s.length()).sum();

        int literalCount=streamSupplier.get().map(s->s.replaceAll("\\\\\\\\", "a")
                .replaceAll("\\\\\"", "a")
                .replaceAll("\\\\[x][0-9abcdeffABCDEFF][0-9abcdeffABCDEF]", "a")
                .replaceAll("\"", "")).mapToInt(s->s.length()).sum();
        int escapeLiteralCount=streamSupplier.get().map(s->s.replaceAll("\\\\\\\\", "aaaa")
                .replaceAll("\\\\\"", "aaaa")
                .replaceAll("\\\\[x][0-9abcdeffABCDEFF][0-9abcdeffABCDEF]", "aaaaa")
                .replaceAll("\"", "aaa")).mapToInt(s->s.length()).sum();

        System.out.println("Length: " + (memoryLength - literalCount));
        System.out.println("Length: " + (escapeLiteralCount - memoryLength));
    }

}
