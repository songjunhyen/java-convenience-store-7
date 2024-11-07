package store.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import store.Model.Product;

public class ProductService {
    private static final String FILE_PATH = "src/main/resources/products.md"; // 파일 경로
    private static final String PARSER = ",";

    // 메인 메서드, 파일을 읽고 파싱하여 Product 리스트 반환
    public static List<Product> getProduct() {
        List<String> lines = readFile(FILE_PATH);  // 파일 읽기
        return parseProductLines(lines);  // 각 줄 파싱하여 Product 객체 리스트로 반환
    }

    // 파일을 읽어서 각 줄을 List<String> 으로 반환하는 메서드
    private static List<String> readFile(String filePath) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean firstLine = true;  // 첫 번째 줄(헤더) 체크용 변수
            while ((line = br.readLine()) != null) {
                // 첫 번째 줄(헤더)을 건너뛰고 처리
                if (firstLine) {
                    firstLine = false;
                    continue;  // 헤더는 건너뜁니다
                }
                if (!line.trim().isEmpty()) {  // 빈 줄은 건너뛰기
                    lines.add(line);  // 유효한 줄만 리스트에 추가
                }
            }
        } catch (IOException e) {
            e.printStackTrace(); // 예외 처리
        }
        return lines;
    }

    // 파일에서 읽은 각 줄을 파싱하여 Product 객체 리스트로 변환하는 메서드
    private static List<Product> parseProductLines(List<String> lines) {
        List<Product> productList = new ArrayList<>();
        for (String line : lines) {
            Product product = parseProduct(line);
            if (product != null) {
                productList.add(product);
            }
        }
        return productList;
    }

    private static Product parseProduct(String line) {
        String[] productDetails = line.split(PARSER);
        if (productDetails.length == 4) {
            String name = productDetails[0];
            int price = Integer.parseInt(productDetails[1]);
            int stock = Integer.parseInt(productDetails[2]);
            String promotion = productDetails[3];

            return createProduct(name, price, stock, promotion);
        }
        return null;
    }

    private static Product createProduct(String name, int price, int stock, String promotion) {
        return new Product(name, price, stock, promotion);  // Product 객체 생성
    }
}