package com.codegym;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class NextDay {
    public static String getTomorrow(String now) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate nowDate = LocalDate.parse(now,formatter);
        nowDate = nowDate.plusDays(1);
        String tomorrow = nowDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return tomorrow;
    }
}
