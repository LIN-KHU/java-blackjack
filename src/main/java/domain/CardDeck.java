package domain;

import java.util.List;

public class CardDeck {
    private List<Card> deck = new CardGenerator().generateCards();

    public CardDeck() {
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


}
