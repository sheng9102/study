package com.sweet.util.study.innerstaticclass;

import java.util.Random;

public class MonitorMain {
    public static void main(String[] args) {
        Random random = new Random();
        Monitor monitor = new Monitor();

        for (int i = 0; i < 1000; i++) {
            String url = "url"+random.nextInt(11);
            monitor.visit(url,"desc",new Double(Math.random()*(10-6+1)+6).longValue());
        }
        for (Monitor.Key key : monitor.getMonitors().keySet()) {
            System.out.println("key"+key+";value:"+monitor.getMonitors().get(key));
        }
    }
}
