package com.meepo.huangshan.bean;


public class y2017426 {

    public static void main(String... args) {
        ManaBall ball = new ManaBall();
        ball.biu(ball).biu(ball).biu(ball);
    }
}


class ManaBall {

    ManaBall biu(ManaBall s) {
        return s;
    }
}