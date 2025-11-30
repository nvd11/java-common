package com.home.javacommon.mockito;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class BuildMockObjTest {

    @Test
    void testBuildMockObj2() {
        StringUtil1 util = Mockito.mock(StringUtil1.class);
        String str = util.formatString("test");
        assertNull(str); // should be null
    }
}


class StringUtil1 {

    public String formatString(String str) {
        return str + ": " + LocalDate.now().toString();
    }
}