package com.sweet.util.study.partnerlogin;

import java.util.concurrent.atomic.AtomicInteger;

public class LoginCheckImpl implements LoginCheck {
    @Override
    public void doCheck() {
        final AtomicInteger currentPosition = new AtomicInteger(0);
        LoginCheck chain = new LoginCheck() {
            @Override
            public void doCheck() {
                System.out.println(currentPosition.getAndIncrement());
            }
        };
        chain.doCheck();
        this.doCheck();
    }
}
