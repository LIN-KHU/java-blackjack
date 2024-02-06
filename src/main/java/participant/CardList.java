package participant;

import carddeck.Card;
import carddeck.CardRank;

import java.util.ArrayList;
import java.util.List;

public class CardList {

    private List<Card> cardList;

    public CardList() {
        this.cardList = new ArrayList<Card>();
    }

    public void addCard(Card card) {
        this.cardList.add(card);
    }

    public int calculateScore() {
        int sum = 0;
        int numOfAce = 0;
        for (Card card : cardList) {
            CardRank cardRank = card.getCardRank();
            if (cardRank.getRank().equals(CardRank.ACE.getRank())) {
                numOfAce += 1;
            }
            sum += cardRank.getValue();
        }
        sum = calculateAceValue(numOfAce, sum);
        return sum;
    }

    private int calculateAceValue(int numOfAce, int sum) {
        for (int i = 0; i < numOfAce; i++) {
            if (sum + 10 <= 21) {
                sum += 10;
            }
        }
        return sum;
    }

    public List<Card> getCardList() {
        return this.cardList;
    }

}
