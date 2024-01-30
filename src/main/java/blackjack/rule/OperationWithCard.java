package blackjack.rule;

import java.util.*;

public class OperationWithCard {
    public interface CardOperation {
        void operate(Map.Entry<String, Integer> shuffledCard);
    }

    public static void performCardOperation(Map<String, List<Integer>> Cards, CardOperation operation) {
        for (int i = 0; i < 2; i++) {
            Map.Entry<String, Integer> shuffledCard = getRandomCard(Cards);
            operation.operate(shuffledCard);
        }
    }

    public static Map.Entry<String, Integer> getRandomCard(Map<String, List<Integer>> Cards) {
        String randomCardName = getRandomCardName(Cards.keySet());

        List<Integer> cardValues = Cards.get(randomCardName);

        int cardvalue = cardValues.get(0);

        Cards.remove(randomCardName);

        return new AbstractMap.SimpleEntry<>(randomCardName, cardvalue);
    }

    public static <T> T getRandomCardName(Set<T> keySet) {
        int randomIndex = new Random().nextInt(keySet.size());
        Iterator<T> iterator = keySet.iterator();
        for (int i = 0; i < randomIndex; i++) {
            iterator.next();

        }
        return iterator.next();
    }
}
