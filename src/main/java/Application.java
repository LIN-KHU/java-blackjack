import controller.BlackJackController;
import view.input.InputView;
import view.output.ResultView;

public class Application {
    public static void main(String[] args) {
        new BlackJackController(new InputView(), new ResultView()).start();
    }
}
