import domain.CalculateScore;
import domain.CardDistributor;
import domain.carddeck.Card;
import domain.carddeck.CardDeck;
import domain.participant.Participant;
import domain.participant.PlayerList;
import view.outputview.OutputView;

public class application {

    public static void main(String[] args) {
        OutputView outputView = new OutputView();

        Participant participant = new Participant("kim");
        CardDeck cardDeck = new CardDeck();

        CardDistributor cardDistributor = new CardDistributor();

        cardDistributor.distributeOneCard(cardDeck, participant);
        cardDistributor.distributeOneCard(cardDeck, participant);
        cardDistributor.distributeOneCard(cardDeck, participant);

        for (Card card : participant.getCardList().getCardList()) {
            System.out.println(card.toString());
        }

        CalculateScore calculateScore = new CalculateScore();
        System.out.println(calculateScore.calculator(participant));
    }
}
