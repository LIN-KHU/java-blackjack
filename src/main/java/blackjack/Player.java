package blackjack;

import java.util.HashMap;

public class Player {

    private String name;
    private Cards cards = new Cards(new HashMap<>());
    private String gameResult;
    private int bettingAmount;
    private Reward reward = new Reward();

    public Player(String name) {
        this.name = name;
    }

    public String getCardNameListToString(){
        return cards.getCardNameListToString();
    }

    public void setGameResult(String state){
        gameResult = state;
    }
    public String getGameResult() {
        return gameResult;
    }

    public String getName() {
        return this.name;
    }

    public void giveCard(HashMap<String, Integer> card) {
        cards.setCards(card);
    }

    public int calculateCardSum() {
        return cards.calculateCardSum();
    }
    public Cards getCards() {return cards;}
    public int getBettingAmount() {
        return bettingAmount;
    }

    public void setBettingAmount(int bettingAmount) {
        this.bettingAmount = bettingAmount;
    }
}
