package blackjack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static blackjack.view.message.MessageConst.*;

public class Cards {

    private HashMap<String, Integer> cardList = new HashMap<>();

    public Cards(HashMap<String, Integer> cardList){
        this.cardList = cardList;
    }

    public void setCards(HashMap<String, Integer> card){
        cardList.putAll(card);
    }
    public HashMap<String, Integer> getCards() {return cardList;}

    public List<String> getCardNameList() {
        return new ArrayList<>(cardList.keySet());
    }

    public int calculateCardSum() {
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

    public String compareValue(Cards cards){
        if(calculateGapCardNumber() < cards.calculateGapCardNumber()){
            return WIN;
        } else if(calculateGapCardNumber() == cards.calculateGapCardNumber()){
            return TIE;
        } else return LOSE;
    }
    private int calculateGapCardNumber() {
        if(calculateCardSum() > 21) {
            return calculateCardSum() - 21;
        } else if(calculateCardSum() == 21) {
            return 0;
        } else return 21 - calculateCardSum();
    }
}
