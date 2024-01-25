package blackjack.view;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }
    public List<String> readPlayerName() {
        String str = scanner.nextLine();
        return Arrays.asList(str.split(","));
    }

}
