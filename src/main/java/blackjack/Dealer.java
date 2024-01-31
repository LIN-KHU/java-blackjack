package blackjack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Dealer {
    private Cards cards = new Cards(new HashMap<>());

    public String getCardListToString(){
        return cards.getCardNameListToString();
    }

    public void getCard(HashMap<String, Integer> card){
        cards.getCards(card);
    }

    public int getSumCardNumber() {
        List<String> cardNameList = cards.getCardNameList();
        /**
         * 모르겠다아
         * */
        for(String cardName: cardNameList){
            if(cardName.contains("A")){
                if(Math.abs(21 - getSumCardNumber()) > Math.abs(21 - getSumCardNumber() +10)){
                    //cardList.replace(cardName, 11);
                }
            }
        }

        return cards.getSumCardNumber();
    }

}
