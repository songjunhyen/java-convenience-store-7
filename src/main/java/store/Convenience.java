package store;

import java.util.List;
import store.Controller.ProductController;
import store.View.InputView;
import store.View.OutputView;

public class Convenience {
    public static void start() {
        OutputView.printStart();
        ProductController.getList();
        String input = InputView.readItem();
        List<String[]> parsedItems = InputView.parseItems(input);
        OutputView.printP(parsedItems);

    }
}
