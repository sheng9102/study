package com.sweet.util.study.JavaDemoTest;

public class RecursiveTest {
    public static void main(String[] args) {
        //Stack(栈) and heap(堆)
        // test Stack out of memory
        testAdd(1);

    }
    static int testAdd(int i){
        if(i>0){
            i=testAdd(i)+i;
        }
        return i;
    }
}
