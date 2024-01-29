package domain.carddeck;

public class CardRankConverter {

    public int converter(CardRank cardRank) {
        if ((cardRank == CardRank.JACK) || (cardRank == CardRank.QUEEN) || (cardRank == CardRank.KING)) {
            return 10;
        }
        if (cardRank != CardRank.ACE) {
            return Integer.parseInt(cardRank.getValue());
        }
        return 0;
    }
}
