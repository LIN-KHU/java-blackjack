package domain;

import domain.participant.Dealer;
import domain.participant.Player;

public class ResultEvaluator {

    public void evaluator(Dealer dealer, Player player) {
        int dealerScore = dealer.getCardList().getScore();
        int playerScore = player.getCardList().getScore();
    }

}
