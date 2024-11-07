package store.Model;

public class Product {
    private String name;      // 제품 이름
    private int price;        // 가격
    private int stock;        // 재고
    private String promotion; // 프로모션 (할인 등)
    private int discount;     // 프로모션 할인율
    private boolean isMembership; // 멤버십 여부 (true: 멤버십 회원, false: 비회원)

    // 생성자
    public Product(String name, int price, int stock, String promotion) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.promotion = promotion;
        this.isMembership = false;
        this.discount = calculateDiscount(promotion); // 프로모션에 따른 할인율 계산
    }

    // promotion에 따른 할인율 계산
    private int calculateDiscount(String promotion) {
        if (promotion == null || promotion.equals("null")) {
            return 0; // 할인 없음
        }
        if (promotion.equals("MD추천상품")) {
            return 100;
        }
        if (promotion.equals("탄산2+1")) {
            return 50;
        }
        if (promotion.equals("반짝할인")) {
            return 30;
        }
        return 0;
    }

    // 프로모션 후 할인된 가격 계산
    public int getDiscountedPrice() {
        int promoPrice = price - (price * discount / 100); // 프로모션 적용 후 가격
        return promoPrice;
    }

    // 멤버십 할인을 적용한 가격 계산
    public int getFinalPrice() {
        int promoPrice = getDiscountedPrice(); // 프로모션 적용 후 가격

        if (isMembership) {
            int membershipDiscount = (int) (promoPrice * 0.30);
            membershipDiscount = Math.min(membershipDiscount, 8000); // 최대 8,000원까지 할인

            promoPrice -= membershipDiscount; // 멤버십 할인을 적용한 최종 가격
        }

        return promoPrice;
    }

    // getter 및 setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getPromotion() {
        return promotion;
    }

    public void setPromotion(String promotion) {
        this.promotion = promotion;
        this.discount = calculateDiscount(promotion);
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public boolean isMembership() {
        return isMembership;
    }

    public void setMembership(boolean membership) {
        isMembership = membership;
    }

    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", promotion='" + promotion + '\'' +
                ", discount=" + discount + "%" +
                ", finalPrice=" + getFinalPrice() + " (after membership discount)" +
                '}';
    }
}