package com.sweet.spi;


import com.school.spi.SpiDemoInterface;

public class SpiPeopleDemoImpl implements SpiDemoInterface {
    @Override
    public String sayHello() {
        return "hello 你好呀";
    }
}
