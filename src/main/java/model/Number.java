package model;

import java.util.Random;

public enum Number {
    A(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    K(10),
    Q(10),
    J(10);
    private int rank;

    Number(int rank) {
        this.rank = rank;
    }

    public int getRank() {
        return rank;
    }

    public static Number getRandomNumber() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
}
