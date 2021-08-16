package com.codegym;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTranslateTest {
    @Test
    public void FizzBuzzTranslateTest01() {
        int number = 10;
        String expected = "Buzz";
        String result = FizzBuzzTranslate.FizzBuzz(number);

        assertEquals(expected,result);
    }
    @Test
    public void FizzBuzzTranslateTest02() {
        int number = 30;
        String expected = "FizzBuzz";
        String result = FizzBuzzTranslate.FizzBuzz(number);

        assertEquals(expected,result);
    }
    @Test
    public void FizzBuzzTranslateTest03() {
        int number = 9;
        String expected = "Fizz";
        String result = FizzBuzzTranslate.FizzBuzz(number);

        assertEquals(expected,result);
    }
    @Test
    public void FizzBuzzTranslateTest04() {
        int number = 2;
        String expected = "2";
        String result = FizzBuzzTranslate.FizzBuzz(number);

        assertEquals(expected,result);
    }
}