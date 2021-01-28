package com.sweet.util.study.spi;

import com.school.spi.SpiDemoInterface;

import java.util.ServiceLoader;

public class SpiMainTest {
    public static void main(String[] args) {
        ServiceLoader<SpiDemoInterface> serviceLoader = ServiceLoader.load(SpiDemoInterface.class);
        for (SpiDemoInterface spiDemoInterface : serviceLoader) {
            System.out.println(spiDemoInterface.sayHello());

        }
    };

}
