package com.home.javacommon.study.staticmember;

import com.home.javacommon.study.Example;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StaticStudy implements Example {
    @Override
    public void runApp() {
        case1();
        case2();
    }

    private void case1(){
        Invoice invoice = new SalesInvoice();
        log.info(invoice.formatId("1234"));
    }

    private void case2(){
        Invoice invoice = new Invoice();
        log.info(((SalesInvoice)invoice).formatId("1234"));
    }


}




class Invoice {
    public static String formatId(String oldId) {
        return oldId + "_Invoice";
    }
}
class SalesInvoice extends Invoice {
    public static String formatId (String oldId) {
        return oldId + "_SalesInvoice";

    }
}