package domain;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final String playerName;
    private final List<Card> playerCardList;
    private int score;
    private boolean winOrNot;

    public Player(String playerName){
        this.playerName = playerName;
        this.playerCardList = new ArrayList<>();
        this.score = 0;
        this. winOrNot = false;
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
    public void isWinner(){
        this.winOrNot = true;
    }
}
