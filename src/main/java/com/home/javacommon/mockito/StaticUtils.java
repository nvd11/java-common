package com.home.javacommon.mockito;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class StaticUtils {

    // do not allow instantiation from outside
    private StaticUtils() {

    }

    public static String formatString(String str) {
        return str + ": " + LocalDate.now().toString();
    }

    public static String getCurrentDateStr() {
        return LocalDate.now().toString();
    }
}
