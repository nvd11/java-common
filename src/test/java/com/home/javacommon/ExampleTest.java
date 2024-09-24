package com.home.javacommon;

import com.home.javacommon.study.lambda.example1.ExampleIntClass;
import com.home.javacommon.study.lambda.example1.ExampleLambda;
import com.home.javacommon.study.lambda.funcref.ExampleFunc1;
import com.home.javacommon.study.lambda.funcref.construct.ExampleConstruct1;
import com.home.javacommon.study.lambda.list.ExampleList1;
import com.home.javacommon.study.lambda.simplification.ExampleSimp1;
import com.home.javacommon.study.lambda.simplification.ExampleSimp2;
import com.home.javacommon.study.lambda.simplification.ExampleSimp3;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;



@SpringBootTest
public class ExampleTest {

    @Autowired
    private ExampleIntClass exampleIntClass;

    @Autowired
    private ExampleLambda exampleLambda;

    @Autowired
    private ExampleSimp1 exampleSimp1;

    @Autowired
    private ExampleSimp2 exampleSimp2;

    @Autowired
    private ExampleSimp3 exampleSimp3;

    @Autowired
    private ExampleFunc1 exampleFunc1;

    @Autowired
    private ExampleConstruct1 exampleConstruct1;

    @Autowired
    private ExampleList1 exampleList1;



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

    @Test
    void testExampleSimp1() {
        exampleSimp1.runApp();
        Assert.isTrue(true,"testExampleSimp1 is done");
    }

    @Test
    void testExampleSimp2() {
        exampleSimp2.runApp();
        Assert.isTrue(true,"testExampleSimp2 is done");
    }

    @Test
    void testExampleSimp3() {
        exampleSimp3.runApp();
        Assert.isTrue(true,"testExampleSimp3 is done");
    }

    @Test
    void testExampleFunc1() {
        exampleFunc1.runApp();
        Assert.isTrue(true,"testExampleFunc1 is done");
    }

    @Test
    void ExampleConstruct1() {
        exampleConstruct1.runApp();
        Assert.isTrue(true,"testExampleConstruct1 is done");
    }

    @Test
    void ExampleExampleList1() {
        exampleList1.runApp();
        Assert.isTrue(true,"testExampleList1 is done");
    }


}
