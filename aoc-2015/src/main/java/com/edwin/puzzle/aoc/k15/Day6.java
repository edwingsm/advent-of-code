package com.edwin.puzzle.aoc.k15;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * --- Day 6: Probably a Fire Hazard ---
 * Because your neighbors keep defeating you in the holiday house decorating contest year after year,
 * you've decided to deploy one million lights in a 1000x1000 grid.
 *
 * Furthermore, because you've been especially nice this year,
 * Santa has mailed you instructions on how to display the ideal lighting configuration.
 *
 * Lights in your grid are numbered from 0 to 999 in each direction;
 * the lights at each corner are at 0,0, 0,999, 999,999, and 999,0.
 *   (990,0)-------------(999,999)
 *     :                    :
 *     :                    :
 *     :                    :
 *     :                    :
 *   (0,0)---------------(0,999)
 *
 * The instructions include whether to
 * turn on, turn off,
 *          or
 * toggle various inclusive ranges given as coordinate pairs.
 *
 * Each coordinate pair represents opposite corners of a rectangle, inclusive;
 * a coordinate pair like 0,0 through 2,2 therefore refers to 9 lights in a 3x3 square. The lights all start turned off.
 *
 * To defeat your neighbors this year, all you have to do is set up your lights by doing the instructions Santa sent you in order.
 *
 * For example:
 *
 * turn on 0,0 through 999,999 would turn on (or leave on) every light.
 * toggle 0,0 through 999,0 would toggle the first line of 1000 lights, turning off the ones that were on,
 * and turning on the ones that were off.
 *
 * turn off 499,499 through 500,500 would turn off (or leave off) the middle four lights.
 * After following the instructions, how many lights are lit?
 *
 *
 * --- Part Two ---
 * You just finish implementing your winning light pattern when you realize you mistranslated Santa's message
 * from Ancient Nordic Elvish.
 *
 * The light grid you bought actually has individual brightness controls;
 * each light can have a brightness of zero or more. The lights all start at zero.
 *
 * The phrase turn on actually means that you should increase the brightness of those lights by 1.
 *
 * The phrase turn off actually means that you should decrease the brightness of those lights by 1, to a minimum of zero.
 *
 * The phrase toggle actually means that you should increase the brightness of those lights by 2.
 *
 * What is the total brightness of all lights combined after following Santa's instructions?
 *
 * For example:
 *
 * turn on 0,0 through 0,0 would increase the total brightness by 1.
 * toggle 0,0 through 999,999 would increase the total brightness by 2000000.
 *
 */
public class Day6 {

    enum State{ON, OFF,TOGGLE;}

    public static class Point{
        public int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            return (int) (x+1)* (y+1) * 31;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj != null && obj instanceof Point) {
                return (x == ((Point) obj).x && y == ((Point)obj).y);
            }
            else {
                return false;
            }
        }

        @Override
        public String toString() {
            return " Point =[x= "+x+",y= "+y+"]";
        }
    }

    public static class Instruction{
        public State state;
        public Point a,b;
        public int brightness;
        public Instruction(Point a, Point b,State state) {
            this.a = a;
            this.b = b;
            this.state =state;
        }

        public Instruction(Point a, Point b,int brightness) {
            this.a = a;
            this.b = b;
            this.brightness =brightness;
        }
    }
    static final Map<Point,State> lightMap= new HashMap<>();
    static final Map<Point,Integer> brightMap= new HashMap<>();
    public static void main(String[] args) throws Exception{

        IntStream.range(0,1000).forEach(i->{
            IntStream.range(0,1000).forEach(j->{
             lightMap.put(new Point(i,j),State.OFF);
              brightMap.put(new Point(i,j),0);
            });
        });

        Path path = Paths.get(Day6.class.getClassLoader()
                .getResource("input/day6.txt").toURI());

        Supplier<Stream<String>> streamSupplier = () -> {
            try {
                return Files.lines(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return Stream.empty();
        };

        streamSupplier.get().map(s->{
            int[] points =parseInput(s);
            State state =parseState(s);
            return new Instruction(new Point(points[0],points[1]),
                    new Point(points[2],points[3]),state);
        }).forEach(i -> executeInstruction(i));

        System.out.println(lightMap.values().stream().filter(v ->v.equals(State.ON)).count());

        streamSupplier.get().map(s->{
            int[] points =parseInput(s);
            int brightness =parseBrightness(s);
            return new Instruction(new Point(points[0],points[1]),
                    new Point(points[2],points[3]),brightness);
        }).forEach(i -> executeBrightness(i));

        System.out.println(brightMap.values().stream().reduce(0, Integer::sum));
    }

    public static int[] parseInput(String input){
         return Arrays.asList(input.replace("turn off", "")
                .replace("turn on ","")
                .replace("toggle ", "")
                .replace("through ",",")
                 .replace(" ","")
                .split(",")).stream()
                .mapToInt(Integer::parseInt).toArray();
    }

    public static State parseState(String input){
        if(input.startsWith("turn off"))
            return State.OFF;
         else if(input.startsWith("turn on"))
             return State.ON;
        else
            return State.TOGGLE;
    }

    public static int parseBrightness(String input){
        if(input.startsWith("turn off"))
            return -1;
        else if(input.startsWith("turn on"))
            return 1;
        else
            return 2;
    }

    public static void executeInstruction(Instruction instruction){
        IntStream.rangeClosed(instruction.a.x,instruction.b.x).forEach( x->{
                IntStream.rangeClosed(instruction.a.y,instruction.b.y).forEach(y->{
                    Point temp = new Point(x,y);
                    State currentState = lightMap.get(temp);
                    State tempState= instruction.state.equals(State.TOGGLE)?toggle(currentState):instruction.state;
                    lightMap.replace(temp,currentState,tempState);
                });
            });
    }

    public static void executeBrightness(Instruction instruction){
        IntStream.rangeClosed(instruction.a.x,instruction.b.x).forEach( x->{
            IntStream.rangeClosed(instruction.a.y,instruction.b.y).forEach(y->{
                Point temp = new Point(x,y);
                int currentState = brightMap.get(temp);
                int tempState= currentState+instruction.brightness<0?0:currentState+instruction.brightness;
                brightMap.replace(temp,currentState,tempState);
            });
        });
    }

    public static State toggle(State state){
        return state.equals(State.OFF)?State.ON:State.OFF;
    }

}
