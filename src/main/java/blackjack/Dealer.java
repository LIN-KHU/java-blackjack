package blackjack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Dealer {
    private Cards cards = new Cards(new HashMap<>());
    private String resultState;
    private int finalReward = 0;
    private GameResult gameResult = new GameResult();

    public String getCardListToString(){
        return cards.getCardNameListToString();
    }

    public void setCards(HashMap<String, Integer> card){
        cards.setCards(card);
    }

    public int calculateCardSum() {
        List<String> cardNameList = cards.getCardNameList();
        /**
         * 모르겠다아
         * */
        for (String cardName : cardNameList) {
            if (cardName.contains("A")) {
                if (Math.abs(21 - calculateCardSum()) > Math.abs(21 - calculateCardSum() + 10)) {
                    //cardList.replace(cardName, 11);
                }
            }
        }

        return cards.calculateCardSum();
    }

}
