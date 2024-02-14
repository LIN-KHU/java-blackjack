package blackjack;

public class Reward {

    private int reward;

    public Reward(){
        reward = 0;
    }

    public void win(Player player){
        reward += player.getBettingAmount();
    }

    public void lose(Player player){
        reward -= player.getBettingAmount();
    }

    public void winPlayerBlackjack(Player player){
        reward += (int) (player.getBettingAmount()*(1.5));
    }

    public void losePlayerBlackjack(Player player){
        reward -= (int) (player.getBettingAmount()*(1.5));
    }
}
