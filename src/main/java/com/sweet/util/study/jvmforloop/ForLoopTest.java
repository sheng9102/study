package com.sweet.util.study.jvmforloop;

public class ForLoopTest {
    void sout(){
        int a = 8;
        while ((a-=3)>0){
            System.out.println(a);
        }
    }

    public static void main(String[] args) {
        ForLoopTest forLoopTest = new ForLoopTest();
        for (int i = 0; i < 50000; i++) {
            forLoopTest.sout();
        }
    }
}
