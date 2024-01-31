import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
class BlackJackTest {

    @RepeatedTest(10)
    void name() {
        // given
        BlackJack blackJack = new BlackJack(new Dealer("dealer", new Hands(new ArrayList<>())),
            List.of(
                new Player("player1", new Hands(new ArrayList<>())),
                new Player("player2", new Hands(new ArrayList<>()))),
            new StubDeck(new LinkedList<>(List.of(
                new Card("10하트", 1),
                new Card("10하트", 10),
                new Card("10하트", 10),
                new Card("A하트", 1),
                new Card("10하트", 10),
                new Card("A하트", 1)
            ))));

        // when
        boolean actual = blackJack.allPlayerWin();

        // then
        assertThat(actual).isTrue();
    }

}
