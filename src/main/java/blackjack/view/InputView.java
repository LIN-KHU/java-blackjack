package blackjack.view;

import java.util.Scanner;
import java.util.function.Function;

public class InputView {
    public static <T> T getInput(String prompt, Function<String, T> parser) {
        T result;

        Scanner scanner = new Scanner(System.in);
        System.out.println(prompt);

        String userinput = scanner.nextLine();
        result = parser.apply(userinput);
        return result;
    }
}
