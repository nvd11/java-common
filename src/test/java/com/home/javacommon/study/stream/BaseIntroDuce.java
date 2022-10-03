package com.home.javacommon.study.stream;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;

import java.io.FileReader;
import java.io.IOException;

public class BaseIntroDuce
{
    public static void main(String[] args) throws IOException {
        Stream1.f();
    }


}

@Slf4j
class Stream1 {
    public static void f() throws IOException {
        FileReader fr = new FileReader(new ClassPathResource("/csv/riskMatrix.csv").getFile()); //restart IDE can solove the Filenotfound Exception

        int ch; //not char
        ch = fr.read(); //throws IOEXCEPTION
        while (ch > -1) { //if ch = -1, means got the end of the file
            System.out.printf("%c", (char) ch);
            ch = fr.read(); //throws IOEXCEPTION
        }
    }
}