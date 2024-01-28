package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BlackJackGame {
    private Dealer dealer = new Dealer();
    private List<Player> players;
    private CardDeck cardDeck = new CardDeck();
    private List<Player> winners = new ArrayList<>();
    public BlackJackGame(List<String> splitPlayerNames) {
        players = splitPlayerNames.stream()
                .map(playerNames -> new Player(playerNames))
                .collect(Collectors.toList());
    }

    public void startPhase() {
        dealer.receiveCard(cardDeck.draw());
        dealer.receiveCard(cardDeck.draw());
        for (Player player : players) {
            player.receiveCard(cardDeck.draw());
            player.receiveCard(cardDeck.draw());
        }
    }
    public void playPhase(String getCardMoreOrNot){
        for (Player player : players){
            eachPlayerPhase(player, getCardMoreOrNot);
        }
    }
    public void eachPlayerPhase(Player player, String getCardMoreOrNot) {
        String answer = "y";
        if(player.getScore() > 17) return;
        while(answer.equals("y") || player.getScore() <= 21){
            answer = getCardMoreOrNot;
            if(answer.equals("n")){
                break;
            }
            player.receiveCard(cardDeck.draw());
        }
    }

    public void dealerPhase(){
        if (dealer.getScore() <= 16)
            dealer.receiveCard(cardDeck.draw());
    }

    public List<Player> getWinner(){
        gattherWinner(players);
        return winners;
    }
    public void gattherWinner(List<Player> players){
        for(Player player : players){
            if(player.getScore() >dealer.getScore()){
                player.isWinner();
                this.winners.add(player);
            }
        }
    }


}
