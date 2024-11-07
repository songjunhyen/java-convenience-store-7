package store.Controller;

import java.util.List;
import store.Model.Product;
import store.Service.ProductService;
import store.View.OutputView;

public class ProductController {
    public static void getList() {
        List<Product> productList = ProductService.getProduct();
        OutputView.printProducts(productList);
    }
}
