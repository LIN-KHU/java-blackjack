package domain;

import constants.Constant;
import constants.Result;
import participant.Dealer;
import participant.Player;

public class DealerWinChecker {

    private final int TARGET_SCORE = 21;
    private int dealerScore;
    private int winNum;
    private int loseNum;
    private int pushNum;

    public DealerWinChecker(Dealer dealer) {
        this.dealerScore = ScoreCalculator.calculateScore(dealer);
        this.winNum = 0;
        this.loseNum = 0;
    }

    public Result checkDealerWin(Player player) {
        int playerScore = ScoreCalculator.calculateScore(player);
        boolean dealerBust = checkBust(this.dealerScore);
        boolean playerBust = checkBust(playerScore);
        if (dealerBust && playerBust) {
            this.loseNum += 1;
            return Result.BUST;
        }
        if (!dealerBust) {
            if (playerBust || (this.dealerScore > playerScore)) {
                this.winNum += 1;
                return Result.PLAYER_LOSE;
            }
        }
        if(!playerBust) {
            if (dealerBust || (playerScore > this.dealerScore)) {
                this.loseNum += 1;
                return Result.PLAYER_WIN;
            }
        }
        if (!(dealerBust && playerBust)) {
            if (playerScore == this.dealerScore) {
                pushNum += 1;
                return Result.PUSH;
            }
        }
        return null;
    }

    private boolean checkBust(int score) {
        if (score > TARGET_SCORE) {
            return true;
        }
        return false;
    }

    public int getWinNum() {
        return this.winNum;
    }

    public int getLoseNum() {
        return this.loseNum;
    }

    public int getPushNum() {
        return this.pushNum;
    }

}
