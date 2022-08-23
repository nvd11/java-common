package com.home.javacommon;

import com.home.javacommon.study.lambda.example1.ExampleIntClass;
import com.home.javacommon.study.lambda.example1.ExampleLambda;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import javax.annotation.Resource;

@SpringBootTest
public class ExampleTest {

    @Resource
    private ExampleIntClass exampleIntClass;

    @Resource
    private ExampleLambda exampleLambda;

    @Test
    void testExampleIntClass() {
        exampleIntClass.runApp();
        Assert.isTrue(true,"testExampleIntClass is done");
    }

    @Test
    void testExampleLambda() {
        exampleLambda.runApp();
        Assert.isTrue(true,"testExampleLambda is done");
    }
}
