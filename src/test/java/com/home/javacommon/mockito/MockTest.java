package com.home.javacommon.mockito;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class MockTest {

    @Test
    void testRealMethod() {

        StringUtil util = new StringUtil();
        String str = util.formatString("test");
        assertEquals("test: " + LocalDate.now().toString(), str);
    }

    @Test
    void testMockMethod() {

        StringUtil util = Mockito.mock(StringUtil.class);
        String str = util.formatString("test");
        assertNull(str); // should be null

        Mockito.when(util.formatString(Mockito.any(String.class))).thenReturn("test: " + "20240101");

        str = util.formatString("test");
        assertEquals("test: " + "20240101", str);
    }

}

class StringUtil {


    public String formatString(String str) {
        return str + ": " + LocalDate.now().toString();
    }
}
