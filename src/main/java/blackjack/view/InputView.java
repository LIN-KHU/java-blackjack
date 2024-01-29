package blackjack.view;

import java.util.*;

public class InputView {
    Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }
    public List<String> readPlayerName() {
        String str = scanner.nextLine();
        checkPlayerName(str);
        return Arrays.asList(str.split(","));
    }

    private void checkPlayerName(String str) {
        try {
            if (str.isBlank()) {
                throw new IllegalArgumentException();
            }
        }
        catch (IllegalArgumentException ex) {
            System.exit(1);
        }
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
