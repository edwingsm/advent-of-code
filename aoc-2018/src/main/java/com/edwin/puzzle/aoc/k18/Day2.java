package com.edwin.puzzle.aoc.k18;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class Day2 {

    public static void main(String[] args) throws Exception{

        List<String> strings = Arrays.asList("abcdef","bababc","abbcde","abcccd","aabcdd","abcdee","ababab");
        Path path = Paths.get(Day1.class.getClassLoader()
                .getResource("input/day2.txt").toURI());

        Supplier<Stream<String>> streamSupplier = () -> {
            try {
                return Files.lines(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return Stream.empty();
        };

        long twoCount = streamSupplier.get()
                .filter(s -> Arrays.stream(s.split(""))
                        .collect(groupingBy(identity(),counting())).values().stream().anyMatch(c -> c == 2))
                .count();

        long     threeCount = streamSupplier.get()
                    .filter(s -> Arrays.stream(s.split(""))
                            .collect(groupingBy(identity(), counting())).values().stream().anyMatch(c -> c == 3))
                    .count();

        System.out.println(String.format("%d & %d",twoCount,threeCount));
        System.out.println(threeCount*twoCount);

        Supplier<Stream<String>> stringStream =()->Stream.of("abcde", "fghij", "klmno", "pqrst", "fguij", "axcye", "wvxyz","axcyb","wvxyc");
        List<String> strings1 =streamSupplier.get().collect(Collectors.toList());
        int i=0,c=strings1.size(),r=0;
        List<PairHolder<String>> pairs =new ArrayList<>();

        for (String s :strings1){
            pairs.addAll(strings1.subList(i,c).stream().filter(e ->e.length() ==s.length()).map(e->diff(s,e)).filter(p->{
                Pair<String> pair = (Pair<String>)p.getPair();
                return pair.first.length() == pair.second.length();
            }).filter(p->{
                Pair<String> pair = (Pair<String>)p.getPair();
                return pair.first.length() ==1;
            }).collect(Collectors.toList()));
           i++;
        }




    }



    /**
     * Returns a minimal set of characters that have to be removed from (or added to) the respective
     * strings to make the strings equal.
     */
    public static PairHolder<String> diff(String a, String b) {
        PairHolder<String> stringPairHolder  =  new PairHolder<>(a,b);
        stringPairHolder.setPair(diffHelper(a, b, new HashMap<>()));
        return stringPairHolder;
    }

    /**
     * Recursively compute a minimal set of characters while remembering already computed substrings.
     * Runs in O(n^2).
     */
    private static Pair<String> diffHelper(String a, String b, Map<Long, Pair<String>> lookup) {
        return lookup.computeIfAbsent(((long) a.length()) << 32 | b.length(), k -> {
            if (a.isEmpty() || b.isEmpty()) {
                return new Pair<>(a, b);
            } else if (a.charAt(0) == b.charAt(0)) {
                return diffHelper(a.substring(1), b.substring(1), lookup);
            } else {
                Pair<String> aa = diffHelper(a.substring(1), b, lookup);
                Pair<String> bb = diffHelper(a, b.substring(1), lookup);
                if (aa.first.length() + aa.second.length() < bb.first.length() + bb.second.length()) {
                    return new Pair<>(a.charAt(0) + aa.first, aa.second);
                } else {
                    return new Pair<>(bb.first, b.charAt(0) + bb.second);
                }
            }
        });
    }

    public static class Pair<T> {
        public Pair(T first, T second) {
            this.first = first;
            this.second = second;
        }

        public final T first, second;

        public String toString() {
            return "(" + first + "," + second + ")";
        }
    }

    public static class PairHolder<T>{
        public Pair<T> pair;
        public T a;
        public T b;

        public PairHolder(T a, T b) {
            this.a = a;
            this.b = b;
        }

        public Pair<T> getPair() {
            return pair;
        }

        public void setPair(Pair<T> pair) {
            this.pair = pair;
        }
    }
}
