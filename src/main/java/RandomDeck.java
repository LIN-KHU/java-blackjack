import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RandomDeck implements Deck{

    private final Queue<Card> cards;

    public RandomDeck() {
        List<Card> cards = new ArrayList<>();
        List<String> cardNumbers = List.of("A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K");
        for (String cardShape : List.of("스페이드", "하트", "클로버", "다이아")) {
            for (int i = 0; i < cardNumbers.size(); i++) {
                String cardName = cardNumbers.get(i) + cardShape;
                if (i < 10) {
                    cards.add(new Card(cardName, i + 1));
                    continue;
                }
                cards.add(new Card(cardName, 10));
            }
        }
        Collections.shuffle(cards);
        this.cards = new LinkedList(cards);
    }

    @Override
    public Card drawCard(){
        return cards.remove();
    }
}
