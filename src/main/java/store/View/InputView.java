package store.View;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputView {
    public static String readItem() {
        System.out.println("구매하실 상품명과 수량을 입력해 주세요. (예: [사이다-2],[감자칩-1])");
        return Console.readLine();
    }

    public static List<String[]> parseItems(String input) {
        List<String[]> items = new ArrayList<>();

        // 입력에서 []로 묶인 각 항목을 처리
        String[] itemEntries = input.replaceAll("[\\[\\]]", "").split(",");

        for (String itemEntry : itemEntries) {
            String[] productDetails = itemEntry.split("-");
            if (productDetails.length == 2) {
                items.add(productDetails);  // [상품명, 수량] 형태
            }
        }
        return items;
    }
}
