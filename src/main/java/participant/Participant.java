package participant;

import carddeck.Card;

import java.util.List;

public class Participant {

    private Name name;
    private CardList cardList;

    public Participant(Name name) {
        this.name = name;
        this.cardList = new CardList();
    }

    public void receiveCard(Card card) {
        this.cardList.addCard(card);
    }

    public String getName() {
        return this.name.getName();
    }

    public int getScore() {
        return this.cardList.calculateScore();
    }

    public List<Card> getCardList() {
        return this.cardList.getCardList();
    }

}
