package domain.participant;

public class Participant {
    private String name;
    private CardList cardList;

    public Participant(String name) {
        this.name = name;
        this.cardList = new CardList();
    }

    public String getName() {
        return this.name;
    }

    public CardList getCardList() {
        return this.cardList;
    }

}
