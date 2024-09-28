package com.home.javacommon.mockito;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class StaticUtilsTest {

    @Test
    void formatString() {
        String str = StaticUtils.formatString("test");
        assertEquals("test: " + StaticUtils.getCurrentDateStr(), str);
    }


    @Test
    void formatString2() {
        try (MockedStatic<StaticUtils> mockedUtil = Mockito.mockStatic(StaticUtils.class)) {

            mockedUtil.when(StaticUtils::getCurrentDateStr).thenReturn("20240101");
            String str = StaticUtils.getCurrentDateStr();

            assertEquals("20240101", str);
        }

        //mockedUtil.when(() -> StaticUtils.getCurrentDateStr()).thenReturn("20240101");

        String str2 = StaticUtils.getCurrentDateStr();

        assertNotEquals("20240101", str2);

    }

    @Test
    void formatString3() {
        MockedStatic<StaticUtils> mockedUtil = Mockito.mockStatic(StaticUtils.class);

        mockedUtil.when(() -> StaticUtils.formatString(Mockito.any(String.class))).thenAnswer((invocation) -> invocation.getArgument(0));

        String str = StaticUtils.formatString("tes222t");

        assertEquals("tes222t", str);

    }

    @Test
    void getCurrentDateStr() {
    }
}

