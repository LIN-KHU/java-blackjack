package blackjack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Cards {

    private HashMap<String, Integer> cardList = new HashMap<>();

    public Cards(HashMap<String, Integer> cardList){
        this.cardList = cardList;
    }

    public void getCards(HashMap<String, Integer> card){
        cardList.putAll(card);
    }

    public List<String> getCardNameList() {
        return new ArrayList<>(cardList.keySet());
    }

    public int getSumCardNumber() {
        int sum = 0;
        List<Integer> cardNumberList = new ArrayList<>(cardList.values());

        for (Integer number : cardNumberList) {
            sum += number;
        }
        return sum;
    }

    public String getCardNameListToString() {
        List<String> cardNameList = getCardNameList();
        return String.join(",", cardNameList);
    }
}
