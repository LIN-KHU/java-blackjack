import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
class BlackJackTest {

    @Test
    void name() {
        // given
        BlackJack blackJack = new BlackJack(new Dealer("dealer", new Hands(new ArrayList<>())),
            List.of(
                new Player("player1", new Hands(new ArrayList<>())),
                new Player("player2", new Hands(new ArrayList<>()))),
            new Deck());

        // when
        boolean actual = blackJack.allPlayerWin();

        // then
        assertThat(actual).isTrue();
    }

}
