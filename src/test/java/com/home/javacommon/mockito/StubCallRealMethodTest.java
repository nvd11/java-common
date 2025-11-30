package com.home.javacommon.mockito;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class StubCallRealMethodTest {

    @Mock
    private StringUtil5 mockUtil;


    @Test
    void testStubCallRealMethod() {
        Mockito.when(mockUtil.formatString(Mockito.any(String.class), Mockito.any(String.class))).thenCallRealMethod();
        String str = mockUtil.formatString("test");
        assertNull(str);

        str = mockUtil.formatString("test", "test2");
        assertEquals("test:test2", str);
    }

    @Test
    void testStubCallRealMethod2() {
        Mockito.doCallRealMethod().when(mockUtil).formatString(Mockito.any(String.class), Mockito.any(String.class));
        String str = mockUtil.formatString("test");
        assertNull(str);

        str = mockUtil.formatString("test", "test2");
        assertEquals("test:test2", str);
    }

    @Test
    void testStubCallRealMethod3() {
        given(mockUtil.formatString(Mockito.any(String.class), Mockito.any(String.class))).willCallRealMethod();
        String str = mockUtil.formatString("test");
        assertNull(str);

        str = mockUtil.formatString("test", "test2");
        assertEquals("test:test2", str);
    }


}


class StringUtil5 {

    public String formatString(String str) {
        return str + ": " + LocalDate.now().toString();
    }

    public String formatString(String str1, String str2) {
        return str1 + ":" + str2;
    }
}


