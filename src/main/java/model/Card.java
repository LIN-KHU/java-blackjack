package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Card {
    private Type type;
    private Number number;

    public Card() {
        Type randomType = Type.getRandomType();
        Number randomNumber = Number.getRandomNumber();
        //객체 간 중복체크 필요
        this.type = randomType;
        this.number = randomNumber;
    }

    public Type getType() {
        return type;
    }

    public Number getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return number.toString()+type.toString();
    }
}
