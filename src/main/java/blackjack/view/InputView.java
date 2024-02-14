package blackjack.view;

import blackjack.model.Participant.PlayerNameList;

import java.util.*;

public class InputView {
    private final Scanner scanner;

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
                throw new IllegalArgumentException("입력값은 y 또는 n이어야만 합니다.");
            }
        }
        catch (IllegalArgumentException ex) {
            System.exit(1);
        }
    }
}
