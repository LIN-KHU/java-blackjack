package blackjack.view;

import blackjack.PlayerNameList;

import java.util.*;

public class InputView {
    Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }
    public PlayerNameList readPlayerName() {
        return new PlayerNameList(scanner.nextLine());
    }

    public char readCommand() {
        char command = scanner.next().charAt(0);
        checkCommand(command);
        return command;
    }

    private void checkCommand(char command) {
        try {
            if (command != 'y' && command != 'n') {
                throw new IllegalArgumentException();
            }
        }
        catch (IllegalArgumentException ex) {
            System.exit(1);
        }
    }
}
