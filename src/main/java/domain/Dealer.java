package domain;

public class Dealer extends Player {
    Dealer(){
        super("Dealer");
    }

    public Card getStartCard(){
        return this.getPlayerCardList().get(0);
    }
}
