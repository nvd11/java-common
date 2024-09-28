package com.home.javacommon.mockito;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(MockitoExtension.class)
public class BuildMockObjWithAnnotationTest {

    @Mock
    private StringUtil1 util;

    @Test
    void testBuildMockObj() {
        String str = util.formatString("test");
        assertNull(str); // should be null
    }
}

