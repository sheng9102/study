package com.sweet.util.study.abinstance;

public class A {
    void say(Object o){
        if(o instanceof A){
            System.out.println("I am A");
        } if (o instanceof B){
            System.out.println("I am B");
        }
    }

}
