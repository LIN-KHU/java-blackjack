package blackjack;

public class GameResult {

    private int dealerWinCount = 0;
    private int dealerLoseCount = 0;

    private String dealerGameResult;
    private String playerGameResult;

    public int getDealerWinCount() {
        return dealerWinCount;
    }

    public void setDealerWinCount(int dealerWinCount) {
        this.dealerWinCount = dealerWinCount;
    }

    public int getDealerLoseCount() {
        return dealerLoseCount;
    }

    public void setDealerLoseCount(int dealerLoseCount) {
        this.dealerLoseCount = dealerLoseCount;
    }
    public String getDealerGameResult() {
        return dealerGameResult;
    }

    public void setDealerGameResult(String dealerGameResult) {
        this.dealerGameResult = dealerGameResult;
    }

    public String getPlayerGameResult() {
        return playerGameResult;
    }

    public void setPlayerGameResult(String playerGameResult) {
        this.playerGameResult = playerGameResult;
    }
}
