package com.home.javacommon.mockito;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
@Slf4j
public class StubAnswerTest {

    @Mock
    private StringUtil4 mockUtil;

    /*
     *  invocation is a concept of the mockito invocation, it includes the context information of the mock
     *  e.g. the argument of the method,  return values
     *
     *  usually, you can use the argument(0) to get the first argument
     *
     *  some methods
     *  getArgument(int index): get the argument at index
     *  getArguments(): get all arguments
     *  getMethod(): get the method
     *  getMock(): get the mock object
     */
    @Test
    void testStubAnswer() {
        Mockito.when(mockUtil.formatString(Mockito.any(String.class), Mockito.any(String.class)))
                .thenAnswer((invocation) -> invocation.getArgument(0) + ":" + invocation.getArgument(1));
        String str = mockUtil.formatString("test", "test2");
        assertEquals("test:test2", str);
    }

    @Test
    void testStubAnswer2() {
        Mockito.doAnswer((invocation) -> invocation.getArgument(0) + ":" + invocation.getArgument(1))
                .when(mockUtil).formatString(Mockito.any(String.class), Mockito.any(String.class));
        String str = mockUtil.formatString("test", "test2");
        assertEquals("test:test2", str);
    }

    @Test
    void testStubAnswer3() {
        given(mockUtil.formatString(Mockito.any(String.class), Mockito.any(String.class)))
                .willAnswer((invocation) -> invocation.getArgument(0) + ":" + invocation.getArgument(1));
        String str = mockUtil.formatString("test", "test2");
        assertEquals("test:test2", str);
    }


}

class StringUtil4 {

    public String formatString(String str1, String str2) {
        return "it's hard coded";
    }
}
