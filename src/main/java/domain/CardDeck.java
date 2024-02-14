package domain;

import java.util.ArrayList;
import java.util.List;

public class CardDeck {
    private List<Card> deck;
    private static final String[] PATTERNS = {"스페이드", "하트", "클로버", "다이아몬드"};
    private static final int MAX_INDEX = 13;

    public CardDeck() {
        deck = new ArrayList<>();
    }

    public Card draw() {
        Card selectedCard = getRandomCard();
        deck.remove(selectedCard);
        return selectedCard;
    }

    public Card getRandomCard(){
        int selectedCardIndex = (int) (Math.random() * deck.size());
        return deck.get(selectedCardIndex);
    }
    public void generateCards() {
        for (String pattern : PATTERNS) {
            for (int i = 1; i <= MAX_INDEX; i++) {
                Card card = new Card(pattern, i);
                deck.add(card);
            }
        }
    }


}
