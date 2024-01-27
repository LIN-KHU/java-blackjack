package domain;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final String playerName;
    private final List<Card> playerCardList = new ArrayList<>();

    private int score = 0;
    public Player(String playerName){
        this.playerName = playerName;
    }

    public void receiveCard(Card receivedCard){
        playerCardList.add(receivedCard);
    }

    public String getPlayerName(){
        return this.playerName;
    }

    public List<Card> getPlayerCardList(){
        return this.playerCardList;
    }

    public int getScore() {
        this.calculateScore();
        return score;
    }
    public void calculateScore(){
        for (Card card : playerCardList){
            score += card.getNumber();
        }
    }
}
