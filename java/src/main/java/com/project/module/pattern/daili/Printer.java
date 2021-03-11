package com.project.module.pattern.daili;

public class Printer implements IPrinter  {

    public void print(){
        System.out.println("打印！");
    }

    @Override
    public void test() {
        System.out.println("测数据");
    }

    @Override
    public void set(String value) {
        System.out.println(value);
    }

}