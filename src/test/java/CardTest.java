import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;

@DisplayNameGeneration(ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
class CardTest {

    @Test
    void 카드는_자신의_값을_계산해준다() {
        // given
        Card aSpade = new Card("A스페이드", 1);

        // when
        int actual = aSpade.calculateValue();

        // then
        assertThat(actual).isEqualTo(1);
    }
}
