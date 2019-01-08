package com.edwin.puzzle.aoc.k18;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day3 {

    public static void main(String[] args) throws Exception {

        Path path = Paths.get(Day1.class.getClassLoader()
                .getResource("input/day3.txt").toURI());

        try (Stream<String> stream = Files.lines(path)) {

//            List<String> list = stream.map(el -> {
//                String s = (String) el;
//                s = s.substring(1).replaceAll(" ", "").replaceAll("[^\\d,]", ",");
//                return s;
//            }).collect(Collectors.toList());
//            Arrays.asList("").stream().mapToInt(Integer::parseInt).toArray();
           List<Rectangle> rectangles= stream.map(el -> {
                String s = (String) el;
                s = s.substring(1).replaceAll(" ", "").replaceAll("[^\\d,]", ",");
                return Arrays.stream(s.split(",")).mapToInt(Integer::parseInt).toArray();
            }).map(el->{int id =el[0];
                    int minX = el[1];
                    int miny =el[2];
                    int maxX= minX+el[3]-1;
                    int maxy=miny+el[4]-1;
                    Point bottomLeft = new Point(minX,miny);
                    Point topRight = new Point(maxX,maxy);
                    return new Rectangle (id,bottomLeft,topRight,el[3]*el[4]);
            }).collect(Collectors.toList());
            //#1 @ 1,3: 4x4 --> min-x -> 0+1=1+4-1=4(max-x)  , miny 0+3=3+4-1=6 (max-y) ||(1,3)-(4-3) & (1,6)-(4,6)
            System.out.println(rectangles.size());
            //https://www.baeldung.com/java-check-if-two-rectangles-overlap
            int count=0, reacts=rectangles.size(),overlapCount=0;
            while (count<reacts) {
                for (Rectangle r : rectangles) {
                    count++;
                    int temp = (int) rectangles.subList(count, reacts).stream()
                            .filter(e -> e.isOverlapping(r))
                            .mapToInt(ar->{return ar.overlapArea;}).sum();
                    overlapCount = overlapCount + temp;

                }
            }
            System.out.println(overlapCount);
        }
    }

    public static class Rectangle {
        public int id;
        public Point bottomLeft;
        public Point topRight;
        public int area;
        public int overlapArea;

        public Rectangle(int id,Point bottomLeft, Point topRight, int area) {
            this.id=id;
            this.bottomLeft = bottomLeft;
            this.topRight = topRight;
            this.area =area;
        }

        boolean isOverlapping(Rectangle other) {
            if (this.topRight.y < other.bottomLeft.y
                    || this.bottomLeft.y > other.topRight.y) {
                return false;
            }
            if (this.topRight.x < other.bottomLeft.x
                    || this.bottomLeft.x > other.topRight.x) {
                return false;
            }
            calculateOverLapArea(other);
            return true;
        }

        void calculateOverLapArea(Rectangle other){
            int len = topRight.x - other.topRight.x;
            int wid = topRight.y - other.topRight.y;
            int overlap = len*wid;
            this.overlapArea = overlap>0? overlap : (overlap*-1);

        }
    }

    public static class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
