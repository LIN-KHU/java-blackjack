package domain;

import participant.Dealer;
import participant.Participant;
import participant.Player;

import java.util.concurrent.Delayed;

public class WinnerChecker {

    private Dealer dealer;
    private int score;

    public (Dealer dealer) {
        this.dealer = dealer;
        this.score = ScoreCalculator.calculateScore(dealer);
    }

    public void check(Player player) {

    }



}
