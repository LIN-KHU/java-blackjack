package blackjack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Player {

    private String name;
    private HashMap<String, Integer> cardList = new HashMap<>();
    private String gameResult;

    public Player(String name) {
        this.name = name;
    }

    public void printCard() {
        List<String> cardNameList = new ArrayList<>();
        cardNameList.addAll(cardList.keySet());

        String s = String.join(",", cardNameList);
        System.out.println(name + "카드: " + s);
    }

    public void setGameResult(String state){
        gameResult = state;
    }
    public String getGameResult() {
        return gameResult;
    }

    public String getName() {
        return this.name;
    }

    public String chooseStayOrHit(String state) {

        if (state.equals("y")) {
            return "y";
        } else if (state.equals("n")) {
            return "n";
        }
        return null;
    }

    public void getCard(HashMap<String, Integer> card) {
        cardList.putAll(card);
    }

    public void printPlayerResult() {
        List<String> cardNameList = new ArrayList<>();
        cardNameList.addAll(cardList.keySet());
        String s = String.join(",", cardNameList);

        for(String cardName: cardNameList){
            if(cardName.contains("A")){
                if(Math.abs(21 - getSumCardNumber()) > Math.abs(21 - getSumCardNumber() +10)){
                    cardList.replace(cardName, 11);
                }
            }
        }

        int sumCardNumber = getSumCardNumber();
        System.out.println(name + "카드: " + s + " - 결과: " + sumCardNumber);
    }

    public int getSumCardNumber() {
        int sum = 0;
        List<Integer> cardNumberList = new ArrayList<>();
        cardNumberList.addAll(cardList.values());

        for (int number : cardNumberList) {
            sum += number;
        }
        return sum;
    }
}
