package com.home.javacommon.study.io;

import com.home.javacommon.study.Example;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileTest implements Example {
    @Override
    public void runApp() {
        File file1 = new File("c:\\tmp\\test.txt");
        File file2 = new File("c:\\tmp\\test2.txt");

        try {
            Files.write(file2.toPath(), "hey".getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
