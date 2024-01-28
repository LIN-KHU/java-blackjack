package view;

import java.util.Scanner;

public class InputView {

    public static String inputPlayerName() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
