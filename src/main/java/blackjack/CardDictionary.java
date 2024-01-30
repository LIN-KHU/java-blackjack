package blackjack;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class CardDictionary {
    public static Map<String, List<Integer>> createCardDictionary() {
        Map<String, List<Integer>> Cards = new HashMap<>();

        for (int i = 2; i <= 10; i++) {
            for (String suit : new String[]{"하트", "스페이드", "클로버", "다이아몬드"}) {
                String cardName = i + suit;
                List<Integer> values = new ArrayList<>();
                values.add(i);
                Cards.put(cardName, values);
            }
        }

        for (String suit : new String[]{"하트", "스페이드", "클로버", "다이아몬드"}) {
            for (String face : new String[]{"J", "Q", "K"}) {
                String cardName = face + suit;
                List<Integer> values = new ArrayList<>();
                values.add(10);
                Cards.put(cardName, values);
            }
        }

        for (String suit : new String[]{"하트", "스페이드", "클로버", "다이아몬드"}) {
            String cardName = suit + "Ace";
            List<Integer> values = new ArrayList<>();
            values.add(1);
            values.add(11);
            Cards.put(cardName, values);
        }
        return Cards; //HashMap [[key: 카드 이름, value = 카드 숫자]]
    }
}
