package store.View;

import java.util.List;
import store.Model.Product;

public class OutputView {
    public static void printStart() {
        System.out.println("안녕하세요. W편의점입니다.");
    }

    public static void printProducts(List<Product> productList) {
        System.out.println("현재 보유하고 있는 상품입니다.");
        for (Product product : productList) {
            System.out.println("- " + product.getName() + " "
                    + product.getPrice() + "원 "
                    + product.getStock() + " "
                    + (product.getPromotion() != null ? product.getPromotion() : ""));
        }
    }

    public static void printP(List<String[]> productList) {
        for (String[] item : productList) {
            String itemName = item[0];
            int quantity = Integer.parseInt(item[1]);

            System.out.println("상품명: " + itemName + "\n" + "수량: " + quantity);
        }
    }
}


