package com.home.javacommon.study.stream;

import com.home.javacommon.study.Example;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.*;

@Slf4j
public class FilterInputStreamStudy implements Example {
    @Override
    public void runApp() {
        FileInputStream fi = null;

        try{
            fi = new FileInputStream("C:\\Users\\gateman\\Documents\\interview.txt");
        }catch(Exception e){
            log.error("Exception occurred: ", e);
        }

        int byt;
        try{
            byt = fi.read();
            while(-1 != byt){
                System.out.print(byt);
                byt = fi.read();
            }
        }catch(IOException e){
            e.printStackTrace();
        }

        //FilterInputStream fi = new FilterInputStream(fileInputStream); //constructor is protected
    }

    public void run2(){
       // FilterReader fr = new FilterReader()   // abstact class
       //OutputStream op = new OutputStream()
    }
}
