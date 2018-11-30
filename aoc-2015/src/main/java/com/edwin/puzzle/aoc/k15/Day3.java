package com.edwin.puzzle.aoc.k15;

/**
 * --- Day 3: Perfectly Spherical Houses in a Vacuum ---
 * Santa is delivering presents to an infinite two-dimensional grid of houses.
 * <p/>
 * He begins by delivering a present to the house at his starting location, and then an elf at the North Pole calls him
 * via radio and tells him where to move next. Moves are always exactly one house to the north (^), south (v), east (>),
 * or west (<). After each move, he delivers another present to the house at his new location.
 * <p/>
 * However, the elf back at the north pole has had a little too much eggnog, and so his directions are a little off,
 * and Santa ends up visiting some houses more than once. How many houses receive at least one present?
 * <p/>
 * For example:
 * <p/>
 * > delivers presents to 2 houses: one at the starting location, and one to the east.
 * ^>v< delivers presents to 4 houses in a square, including twice to the house at his starting/ending location.
 * ^v^v^v^v^v delivers a bunch of presents to some very lucky children at only 2 houses.
 * --- Part Two ---
 * <p/>
 * The next year, to speed up the process, Santa creates a robot version of himself, Robo-Santa, to deliver presents
 * with him.
 * <p/>
 * Santa and Robo-Santa start at the same location (delivering two presents to the same starting house), then take turns
 * moving based on instructions from the elf, who is eggnoggedly reading from the same script as the previous year.
 * <p/>
 * This year, how many houses receive at least one present?
 * <p/>
 * For example:
 * ^v delivers presents to 3 houses, because Santa goes north, and then Robo-Santa goes south.
 * ^>v< now delivers presents to 3 houses, and Santa and Robo-Santa end up back where they started.
 * ^v^v^v^v^v now delivers presents to 11 houses, with Santa going one direction and Robo-Santa going the other.
 * source: http://adventofcode.com/day/3
 * <p/>
 *
 * REF :https://github.com/markwryan/advent-of-code/blob/master/src/main/java/com/markwryan/adventofcode/day3/PresentDeliveryTracker.java
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Day3 {
    public static void main(String[] args) throws IOException {
        URL input = ClassLoader.getSystemResource("input/day3.txt");
        BufferedReader reader = new BufferedReader(new FileReader(input.getPath()));
        String lines = reader.readLine();
        // 1 Santa
        int oneSantaNumberOfHomes = countHome(1, lines);
        System.out.println("1 Santa deliver presnets to " + oneSantaNumberOfHomes + " homes.");

        int twoSantasNumberOfHomes2 = countHome(2, lines);
        System.out.println("2 Santas deliver presents to " + twoSantasNumberOfHomes2 + " homes.");
        reader.close();
    }


    public static int countHome(int numberOfSantas, String input) {
        final Set<Plot> homes = new HashSet<>();
        final Plot[] allSantaPostions = new Plot[numberOfSantas];
        final Plot start = new Plot(0, 0);
        homes.add(start);
        for (int j = 0; j < numberOfSantas; j++) {
            allSantaPostions[j] = start;
        }

        char[] directions = input.toCharArray();
        int santaIndex = 0;
        for (char direction : directions) {
            final Plot location = plotSanta(allSantaPostions[santaIndex], direction);
            homes.add(location);
            allSantaPostions[santaIndex] = location;

            santaIndex++;
            if (santaIndex >= numberOfSantas) {
                santaIndex = 0;
            }
        }
        return homes.size();
    }


    private static Plot plotSanta(final Plot locationOfSanta, final char direction) {
        int x = locationOfSanta.x;
        int y = locationOfSanta.y;
        if (direction == '^') {
            y++;
        } else if (direction == 'v') {
            y--;
        } else if (direction == '<') {
            x--;
        } else if (direction == '>') {
            x++;
        }
        return new Plot(x, y);
    }

    public static class Plot {
        int x;
        int y;

        public Plot(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Plot plot = (Plot) o;
            return x == plot.x &&
                    y == plot.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
