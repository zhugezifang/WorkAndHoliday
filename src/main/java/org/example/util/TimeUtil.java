package org.example.util;

import java.time.LocalDateTime;

public class TimeUtil {
    public static String getCurrentYear() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        int currentYear = currentDateTime.getYear() + 1;
        System.out.println("Current year: " + currentYear);
        return currentYear + "";
    }

    public static void main(String[] args) {
        getCurrentYear();
    }

}
