package blackjack.model.Participant;

import java.util.Arrays;
import java.util.List;

public class PlayerNameList {

    private final List<String> playerNameList;

    public PlayerNameList(String str) {
        validateNameList(str);
        this.playerNameList = Arrays.asList(str.split(","));
    }

    private void validateNameList(String str) {
        try {
            if (str.isBlank()) {
                throw new IllegalArgumentException("공백으로만 이뤄지지 않은 한 명 이상의 이름이 입력되어야 합니다.");
            }
        }
        catch (IllegalArgumentException ex) {
            System.exit(1);
        }
    }
    public List<String> getPlayerNameList() {
        return playerNameList;
    }
}
