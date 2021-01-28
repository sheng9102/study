package com.sweet.spi;


import com.school.spi.SpiDemoInterface;

public class SpiDogDemoImpl implements SpiDemoInterface {
    @Override
    public String sayHello() {
        return "wangwang";
    }
}
