package blackjack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Dealer {

    private HashMap<String, Integer> cardList = new HashMap<>();

    public void printCard() {
        List<String> cardNameList = new ArrayList<>();
        cardNameList.addAll(cardList.keySet());

        String s = String.join(",", cardNameList);
        System.out.println("딜러: " + s);
    }

    public void getCard(HashMap<String, Integer> card){
        cardList.putAll(card);
    }

    public int getSumCardNumber() {
        int sum = 0;
        List<Integer> cardNumberList = new ArrayList<>();
        cardNumberList.addAll(cardList.values());

        for(int number: cardNumberList){
            sum += number;
        }
        return sum;
    }

    public void printDealerResult() {
        List<String> cardNameList = new ArrayList<>();
        cardNameList.addAll(cardList.keySet());
        String s = String.join(",", cardNameList);

        int sumCardNumber = getSumCardNumber();
        System.out.println("딜러 카드: " + s + " - 결과: "+sumCardNumber);
    }

}
