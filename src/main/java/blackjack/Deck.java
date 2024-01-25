package blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Deck {
    private final List<String> deckList;
    public  Deck() {
        List<String> shapeList = List.of("하트", "스페이드", "클로버", "다이아");
        List<String> numberList = List.of("2", "3", "4", "5", "6", "7", "8", "9", "A", "K", "Q", "J");
        this.deckList= new ArrayList<>();
        for (String number : numberList) {
                for (String shape : shapeList) {
                    deckList.add(number+shape);
                }
            }
        Collections.shuffle(deckList);
        }
    public String getNewCard() {
        return deckList.remove(0);
    }
}
