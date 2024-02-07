package model;

import java.util.Random;

public enum Type {

    하트, 스페이드, 다이아몬드, 클로버;

    public static Type getRandomType() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
}
