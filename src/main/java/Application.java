import controller.BlackJackGame;
import model.Dealer;
import model.Player;
import model.PlayerList;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        BlackJackGame.start();
    }
}
