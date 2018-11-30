package com.edwin.puzzle.aoc.k15;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

public class Day1Test {

    @Test
    @DisplayName("Happy Path")
    public void test_Happy_Path_For_Santha(){
        Day1 day1 = new Day1("(((())))()((((((((())()(()))(()((((()(()(((()((()((()(()()()()()))(((()(()((" +
                "((((((((())(()()((())()(((())))()(()(()((()(()))(()()()()((()((()(((()()(((((((()()())()((((()()" +
                "(((((()(())()(())((())()()))()(((((((())(()())(()(((())(()))((())))(()((()())))()())((((())))(()((" +
                "(((()(())(((()()((()((()((((((((((())(()())))))()))())()()((((()()()()()()((((((())())(((()())()((()()" +
                "(((()()()))(((((()))(((()(()()()(()(()(((())()))(()(((()((())()(()())())))((()()()(()()(((()))(((()((" +
                "((()(((((()()(()())((()())())(()((((((()(()()))((((()))))())((())()()((()(()))))((((((((()))(()()" +
                "(((())())(())()((()()()()((()((()((()()(((())))(()((())()((((((((()((()(()()(((())())())))(())())))()" +
                "((((()))))))())))()()))()())((()())()((()()()))(()()(((()(())((((())())((((((((()()()()())))()()()((" +
                "((()()))))))()((((()(((()))(()()())))((()()(((()))()()())())(((())((()()(())()()()(((())))))()())(((" +
                ")))()))((())()()())()())()()(()))())))())()))(())((()(())))(()(())(()))))(()(())())(()(())(()(()))))" +
                "((()())()))()((((()()))))())))()()())((())()((()()()))()(((()(()))))(())()()))(((()())))))))))(((()))" +
                ")()))())()))))()()(((())))))))()(()()(()))((()))))((())))((()((())))())))()()(()))())()(()((()())(()(" +
                "()()())())(()()))()))))(()())()()))()()()()))(()(()(()))))))()(()))()))()()(()((())(()(())))()(((())(" +
                "())())))))()(()(()))))()))(()()()(())()(()(())))()))))()()(((((())))))())()())())())()())()))))()))))" +
                "))))())()()()()()()())))()))((())()))())))()((())()))))()))())))))))())()()()))()()(()((((()(((((((()((" +
                "))((()())((()()))()))))(())))()()()(())((())()())))(())))(())))(((()()))()(())(((()(()))((())))())()))" +
                "((((()))())()))))))))()(())())))(()))()(()()))())()()(())())))())()()(()())))()((()())(()(())(()))))))" +
                ")))))))(()))))()))))))()()())(()(((((()(()())))())()))(()))()))(()()))()())(()))())()(())((()()))))))(" +
                "))))())()(((())))(()(()))()()))()(()))))))((()())(()))))))()())))()()))))))))((((((((()()()(()))))))()" +
                "())))())))()()((())()))((())(())))())())))()()()((()((()(())))())()(())))))))))()())))()()()()()()))()" +
                "))((())())(()(()))))))(()()))()))(())))()))))))))))))(()))))))))()))))()))()())()))()()))))))()))))((()" +
                "))))(()))())()(())))(()())((((()())))()))))(()))()(()()(())))))())))))()))))))())))())))))())))())())))" +
                "())(()))))(())()(())))())()))((()()))))))())))((())))))))())))(())))))()()())))))())))))()))))))()))()()(" +
                ")(()(((()())())())(()))())))))((()(())(()))))))))(())))()()()())())(()))))()()()))()))())())())()(())))(" +
                ")(((()((((())))))))()))))))))))))))))))))((())()())(()))))()()))))))(()()(())())))())))((())))((()))))))" +
                ")))))))()))))()(()))))))())))))()))(()()())(()())))))))))()))))))(())))))()()))()())(((())))()))(())))))" +
                ")))(())())))())))())())())()()))((())()(())()())()))()())(())(()))))()())))(()(((()))))))()(()())()()()))()))" +
                "))))))()()()(())()())()(((((()))()())())(()))))()()()(())))())))()((()())))(()))())()(()())())(()))()()))" +
                "((()()))((()()()()())))(())()))(()(())))((()()))))))))())))))))())()()))))))))))))))))(())()(())(())()(" +
                "))())()))()(()))))())())))))()())()(()))()()(())))(())())))))(()))))))))))))))())())(())(())))(((()))()" +
                "))))())((())(()))())))))))())))))())))()))()))))))))))))())()))))()))))((()))(())))()(())))(())()))()))" +
                "())))())))))))()(()())())))()()())))(())))))(()))))))))))))(()))()))()))())))(((()()()(())((()())))()()" +
                ")(((()))(())()))((()()()())))())(())(()))))()(((((())))(()))())())))))))((((()()()))())())()(()(()())))" +
                "))))))()())())))(())))()())(((()(())())()()))())())))))))((()())((()()(()))(()(())))()))()))(()))(()))(" +
                ")()(()(((())((((()))()(()))((())()(()(()())()(()))()())))))(()))()))())()())))())))(())))((())(()())))))" +
                "()))(())(()))()())()(()()((()(()))))))()(())(()())(())()))(((())()))(()()(()()()))))(()(())))()))))())))" +
                "))())(()()()()()()(((())))(()()))()((())(((((()()())))(()))(()))()()))(((())())()(((()()()()))))(()))((" +
                "))())))()())(()()())())))))))()))))((())))()())(()))(()(()))())))))())(())))))()()())())()))()()(())))(" +
                "()))(())((((((())(()))(()))())()))(()()(())))()))(()()))()))()(())))(())))((()(()))(())()()())())))(((()" +
                "()())(())()))))))()(((()(((((()()(((())(())))())()((()))))((()())()(())(((())))(((()((()(()(()))(()()))(" +
                "))(()))(())(())))()))))))((((()))()((((()(()))()))()()))))()(()(()))()(()((()(((()(()()(((()))))()(((()" +
                "(()(()(((()(()())())()()(()(()())())(()((((())(()))()))(((((()()())(())()((()()())))()()(((()()))()((((" +
                "((((()(())))())((()))))(())))(()))))((()((((()()(())(((((()))(((((((((((((()())))((((()(((()((())())()))" +
                "((()))()(()()((()()()()(()()(()(()(((())()(()((((((()((()()((())()((((()((()()(()()())((()()()((()((())" +
                "()(()(((()((())((((())(()))((()(()))(()())()((((((((()(((((((((((()))(()(((()(()()()((((())((())()())" +
                "()))(())((())(()))(((()((()(())))(()))))((()()))))((((()(()(()())(()(())((((((((()((((()((()(((((()))" +
                "())()(()))(()()((()(())(((((()(())()(((((()()))))))()(((())()(()()((((())()((())((()(((())(((()))((()" +
                "()((((()(())))))((()((((()((()((()(((())((()))(((((((()(((()((((((((())()))((((())(((((()((((((((()" +
                "(((()((()(((()()(((()((((((()()(()((((((((()()(()(()(())((((()())()))))(((()))((((())((((()())((()" +
                "(())()((()((((((()((((((()(())))()())(((())())())()(())()(()())((()()((((())((((((())(()(((((()(((((" +
                "))()((((()(()(())(()())(((())()((())((((()))()((((((())(()(((()(((()((((((()(((()))(()()())())((()(((" +
                ")())()((((())(((()(()(((((((((())(())))()((()()()()(())((()))(((((((()(((((((((()(()))))(()((((((((()" +
                "((((()((()()((((((()()(((((((()(()(())()(())((()()()((()(((((()())()(((((()())()()((()(()())(()()()((" +
                "(()()(((((()((((((()()((()(()()()((((((((((((()((((((((()()(((()())))()(((()()(())())((((()((((()(((((" +
                ")()()(())(())((()(()(((((((((((((((()(())(())))))()()))((()(((()(())((()(((()(()()((((()()(((()(((()(" +
                "((((()()((()(()(((()))((((((()((((((((()((()((())(((((()(((())(())())((()()))((((())()()((()(((()((((" +
                "(()()(((()))(((()(()(((((((((((((()))((((((((()(((()))))())((((((((((((())((())((()())(((())((())(()" +
                "((((((((((()(((())((()()(()((())(((((((((((()))((((((((((((()(()())((()((()((()(()(((()((((((((()()" +
                "(()((()(()(((()))((()))(((((((((((((()(())((((((())(((()(())(()(()(()((()()))((((()((((()((((())))()" +
                ")((((()((((()))((((((()((((((()((()(((())))((())(()))(()((()((((()((()(((()()))((((()()()(((((((())" +
                "(((())(()))())((((()())(((()(((((((((((()(()(()((()(((((((((((((((()()((((()((((((((()(((()()((()((" +
                "((()))(((()(())((((((()((((())()((((()((()))(())()(()(((()((())())((((((()(()(())())(((())(()(()())(" +
                "((((()((()((())()())(())))(((()(())))))))(((()(((()))()((()(((()()((()())()()))())))(((()))(()(((()" +
                "(((((((((()(()(((((()()(((()())()()))))()(((()))(((()(()(()(()(()))()(())()))(()(((())))(()))))))))))(())" +
                "((()((())((()(())()(())((()()((((()()((()()))((())(((()((()(())(())))()(()(((((()((()))())()(((((()()(((()" +
                "(()((((((())(()))(())()))((()(()()))(())())()))(((())))(()((()(((())(())())))((()()((((((((((((((()((()" +
                "(()()(()(((()))())()()((()()()(())(()))(()())(((())((())()(())()()(()()(())))((()(((()))))(((()()(()())" +
                ")())((()((())()))((((()()()())((())))(((()(())(((((()(((((()((()(()((((()()(((()()()(((()())(((()()" +
                "((((())(()))(((()))(())())((()))(((()((()))(((()()((())((()(((((()((((()()())((()))()((((()((()(()()()(");
        Assert.assertEquals(day1.calculateFloor(),232);
    }

    @Test
    @DisplayName("throws EmptyStackException when path is empty")
    public void test_CalculateFloor_throws_Exception_For_Empty_Path() {
        Day1 day1 = new Day1(" ");
        Assertions.assertThrows(IllegalArgumentException.class, () -> day1.calculateFloor());
    }

    @Test
    @DisplayName("throws IllegalArgumentException when Path contains chars other than '(' & ')'")
    public void test_CalculateFloor_throws_Exception_For_Invalid_Path() {
        Day1 day1 = new Day1("() ((((");
        Assertions.assertThrows(IllegalArgumentException.class, () -> day1.calculateFloor());
    }

    @Test
    @DisplayName("throws IllegalArgumentException when Path is null")
    public void test_CalculateFloor_throws_Exception_For_Null_Path() {
        Assertions.assertThrows(NullPointerException.class, () -> new Day1(null));
    }
}
