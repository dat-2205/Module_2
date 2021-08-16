package com.codegym;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

public class NextDayTest {
    @Test
    @DisplayName("Testing nextday 01")
    public void testNextDay01() {
        String expected = "17/08/2001";
        String result =  NextDay.getTomorrow("16/08/2001");

        assertEquals(expected,result);
    }
    @Test
    @DisplayName("Testing next day 02")
    public void testNextDay02() {
        String expected = "22/05/1999";
        String result =  NextDay.getTomorrow("22/05/1999");

        assertEquals(expected,result);
    }
}
