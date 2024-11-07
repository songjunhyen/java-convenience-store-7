package store.View;

import java.util.List;
import store.Model.Product;

public class OutputView {
    public static void printProducts(List<Product> productList) {
        for (Product product : productList) {
            System.out.println(product);
        }
    }
}


