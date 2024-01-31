package blackjack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Player {

    private String name;
    //private HashMap<String, Integer> cardList = new HashMap<>();
    private Cards cards = new Cards(new HashMap<>());
    private String gameResult;

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

    public String chooseStayOrHit(String state) {

        if (state.equals("y")) {
            return "y";
        } else if (state.equals("n")) {
            return "n";
        }
        return null;
    }

    public void getCard(HashMap<String, Integer> card) {
        cards.getCards(card);
    }

    public int getSumCardNumber() {
        return cards.getSumCardNumber();
    }
}
