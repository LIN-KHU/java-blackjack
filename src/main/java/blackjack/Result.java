package blackjack;

public class Result {
    private int win;

    public Result() {
        this.win = 0;
    }

    public int getWin() {
        return win;
    }

    public void setWin() {
        this.win++;
    }
}
