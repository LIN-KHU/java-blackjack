package blackjack.model.Game;

public class Result {
    private int winCount;

    public Result() {
        this.winCount = 0;
    }

    public int getWinCount() {
        return this.winCount;
    }

    public void win() {
        this.winCount++;
    }
}
