package com.home.javacommon.study.queue;

import com.home.javacommon.study.Example;

import java.util.LinkedList;
import java.util.Queue;

public class QueueStudy implements Example {
    @Override
    public void runApp() {
        Queue<String> queue = new LinkedList();
        queue.offer("a");
        queue.offer("c");
        String headStr = queue.element(); // a

    }
}
