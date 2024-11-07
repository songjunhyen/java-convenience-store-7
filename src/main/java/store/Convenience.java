package store;

import store.Controller.ProductController;
import store.View.OutputView;

public class Convenience {
    public static void start() {
        OutputView.printStart();
        ProductController.getList();
    }
}
