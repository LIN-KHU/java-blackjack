package blackjack.model.Card;

import java.util.*;

public class Deck {
    private final Queue<String> deckList;
    public  Deck() {
        List<String> shapeList = List.of("하트", "스페이드", "클로버", "다이아");
        List<String> numberList = List.of("2", "3", "4", "5", "6", "7", "8", "9", "A", "K", "Q", "J");
        List<String> cardList = new ArrayList<>();
        for (String number : numberList) {
                for (String shape : shapeList) {
                    cardList.add(number+shape);
                }
            }
        Collections.shuffle(cardList);
        this.deckList= new LinkedList<>(cardList);
        }
    public String getNewCard() {
        return deckList.remove();
    }
}
