import model.Player;
import view.InputView;
import view.OutputView;

import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        OutputView.printInputPlayerNameMessage();
        String playerNames = InputView.inputPlayerName();
        List<String> playerNameList = Arrays.asList(playerNames.split(","));
        for (String playerName : playerNameList) {
            Player player = new Player(playerName);
        }


    }
}
