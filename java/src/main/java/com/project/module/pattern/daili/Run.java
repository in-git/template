package com.project.module.pattern.daili;

public class Run {
    public static void main(String[] args) {
        ProxyHandler proxyHandler=new ProxyHandler();
        IPrinter printer=(IPrinter) proxyHandler.newProxyInstance(new Printer());
        printer.test();
        printer.print();
        printer.set("Hello");
    }
}
