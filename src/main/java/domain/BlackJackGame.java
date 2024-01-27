package domain;

import view.input.InputView;

import java.util.List;
import java.util.stream.Collectors;

public class BlackJackGame {
    private InputView input = new InputView();
    private Dealer dealer = new Dealer();
    private List<Player> players;
    private CardDeck cardDeck = new CardDeck();

    BlackJackGame(List<String> splitPlayerNames) {
        players = splitPlayerNames.stream()
                .map(playerNames -> new Player(playerNames))
                .collect(Collectors.toList());
    }

    public void play() {
       startPhase();
       playPhase();

    }

    public void startPhase() {
        dealer.receiveCard(cardDeck.draw());
        dealer.receiveCard(cardDeck.draw());
        if (dealer.getScore() <= 16)
            dealer.receiveCard(cardDeck.draw());
        for (Player player : players) {
            player.receiveCard(cardDeck.draw());
            player.receiveCard(cardDeck.draw());
        }
    }
    public void playPhase(){
        for (Player player : players){
            eachPlayerPhase(player);
        }
    }
    public void eachPlayerPhase(Player player) {
        String answer = "";
        while(answer != "n" || player.getScore() <= 21){
            answer = input.readGetCardMoreOrNot(player.getPlayerName());
            if(answer == "n"){
                break;
            }
            player.receiveCard(cardDeck.draw());
        }
    }
}
