package com.home.javacommon.mockito;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.commons.function.Try;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
@Slf4j
public class StubTest {

    @Mock
    private StringUtil3 mockUtil;

    @Test
    void testStubReturn() {
        Mockito.when(mockUtil.formatString(Mockito.any(String.class))).thenReturn("test: " + LocalDateTime.now().toString());
        String str = mockUtil.formatString("test");
        log.info("str: {}", str);
        assertNotNull(str);
    }

    @Test
    void testStubReturn2() {
        Mockito.doReturn("test: " + LocalDateTime.now().toString()).when(mockUtil).formatString(Mockito.any(String.class));
        String str = mockUtil.formatString("test");
        log.info("str: {}", str);
        assertNotNull(str);
    }

    @Test
    void testStubReturn3() {
        given(mockUtil.formatString(Mockito.any(String.class))).willReturn("test: " + LocalDateTime.now().toString());
        String str = mockUtil.formatString("test");
        log.info("str: {}", str);
        assertNotNull(str);
    }

    @Test
    void testStubThrow() {
        Mockito.when(mockUtil.formatString(Mockito.any(String.class))).thenThrow(new UnsupportedOperationException());
        String str = null;
        assertThrows(UnsupportedOperationException.class, () ->  mockUtil.formatString("test"));
    }

    @Test
    void testStubThrow2() {
        Mockito.doThrow(new UnsupportedOperationException()).when(mockUtil).formatString(Mockito.any(String.class));
        String str = null;
        assertThrows(UnsupportedOperationException.class, () ->  mockUtil.formatString("test"));
    }

    @Test
    void testStubThrow3() {
        given(mockUtil.formatString(Mockito.any(String.class))).willThrow(new UnsupportedOperationException());
        String str = null;
        assertThrows(UnsupportedOperationException.class, () ->  mockUtil.formatString("test"));
    }

    @Test
    void testStubNotThrow() {
        Mockito.doNothing().when(mockUtil).formatString2(Mockito.any(String.class));
        assertDoesNotThrow(() -> mockUtil.formatString2("test"));
    }

}

class StringUtil3 {

    public String formatString(String str) {
        return str + ": " + LocalDate.now().toString();
    }

    public void formatString2(String str) {
        throw new UnsupportedOperationException();
    }
}
