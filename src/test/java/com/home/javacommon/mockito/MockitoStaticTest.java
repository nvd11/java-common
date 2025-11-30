package com.home.javacommon.mockito;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class MockitoStaticTest {

    @Test
    void testMockitoStatic() {

        try (MockedStatic<StringUtil9> mockStaticObj = Mockito.mockStatic(StringUtil9.class)) {
            given(StringUtil9.formatString(Mockito.any(String.class))).willReturn("test: " + "20241111");
            assertEquals("test: " + "20241111", StringUtil9.formatString("test"));
        } // try will auto execute the mockStaticObj.close()


        assertEquals("test: " + "20000101", StringUtil9.formatString("test"));

    }
}


class StringUtil9 {

    public static String formatString(String str) {
        return str + ": " + "20000101";
    }
}