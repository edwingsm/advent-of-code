package com.edwin.puzzle.aoc.k15;

import com.google.common.collect.Collections2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Day9 {



    public static void main(String[] args) throws Exception {
        Path path = Paths.get(Day6.class.getClassLoader()
                .getResource("input/day9.txt").toURI());
        Supplier<Stream<String>> streamSupplier = () -> {
            try {
                return Files.lines(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return Stream.empty();
        };

        streamSupplier.get().map(str -> str.split(" "))
                .forEach((str) -> {
                    addCitiesToMap(str[0], str[2], Integer.parseInt(str[4]));
                    addCitiesToMap(str[2], str[0], Integer.parseInt(str[4]));
                });
        List<Integer> distances = getAllPossibleRouteLengths();
        System.out.println(distances.stream().min(Integer::compare).get());
        System.out.println(distances.stream().max(Integer::compare).get());
    }

    protected static Map<String, HashMap<String, Integer>> routeTableMap = new HashMap<>();

    private static void addCitiesToMap(String city1, String city2, int distance) {
        if (!routeTableMap.containsKey(city1)) {
            routeTableMap.put(city1, new HashMap<>());
        }
        routeTableMap.get(city1).put(city2, distance);
    }

    private static List<Integer> getAllPossibleRouteLengths() {
        Collection<List<String>>  possibleRoutes = Collections2.permutations(routeTableMap.keySet());
        List<Integer> cities = getRouteLengths(possibleRoutes);
        return cities;
    }

    private static List<Integer> getRouteLengths(Collection<List<String>>  allRoutes) {
        List<Integer> result = new ArrayList<>();
        for (List<String> aRoute : allRoutes) {
            int routeLength = 0;
            for (int i = 0; i < aRoute.size() - 1; i++) {
                routeLength += getDistanceBetweenCities(aRoute.get(i), aRoute.get(i + 1));
            }
            result.add(routeLength);
        }
        return result;
    }

    private static int getDistanceBetweenCities(String city1, String city2) {
        return (int) routeTableMap.get(city1).get(city2);
    }


}
