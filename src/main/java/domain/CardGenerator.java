package domain;

import java.util.ArrayList;
import java.util.List;

public class CardGenerator {
    private List<Card> cards = new ArrayList<>();
    private static final String[] PATTERNS = {"스페이드", "하트", "클로버", "다이아몬드"};
    private static final int MAX_INDEX = 13;

    CardGenerator() {
    }

    public List<Card> generateCards() {
        for (String pattern : PATTERNS) {
            for (int i = 1; i <= MAX_INDEX; i++) {
                Card card = new Card(pattern, i);
                cards.add(card);
            }
        }
        return cards;
    }

}
