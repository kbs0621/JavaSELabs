package mylab.book.control;

import mylab.book.entity.Publication;
import mylab.book.entity.Novel;
import mylab.book.entity.Magazine;
import mylab.book.entity.ReferenceBook;
import java.util.*;

public class ShoppingCart {
    private List<Publication> items = new ArrayList<>();

    public ShoppingCart() {}

    // 아이템 추가
    public void addItem(Publication pub) {
        items.add(pub);
        System.out.println(pub.getTitle() + "이(가) 장바구니에 추가되었습니다.");
    }

    // 아이템 제거
    public boolean removeItem(String title) {
        for (Publication p : items) {
            if (p.getTitle().equals(title)) {
                items.remove(p);
                System.out.println(title + "이(가) 장바구니에서 제거되었습니다.");
                return true;
            }
        }
        return false;
    }

    // 장바구니 출력
    public void displayCart() {
        System.out.println("====== 장바구니 내용 ======");
        int index = 1;
        for (Publication p : items) {
            System.out.printf("%d. %s - %,d원%n", index++, p.getTitle(), p.getPrice());
        }
        System.out.printf("총 가격: %,d원%n", calculateTotalPrice());
        System.out.printf("할인 적용 가격: %,d원%n", calculateDiscountedPrice());
    }

    // 총 가격 계산
    public int calculateTotalPrice() {
        int sum = 0;
        for (Publication p : items) {
            sum += p.getPrice();
        }
        return sum;
    }

    // 할인 가격 계산 (전체 15% 할인 예시)
    public int calculateDiscountedPrice() {
        return (int)(calculateTotalPrice() * 0.85);
    }

    // 장바구니 통계 출력
    public void printStatistics() {
        System.out.println("====== 장바구니 통계 ======");
        int novelCount = 0, magazineCount = 0, refCount = 0;
        for (Publication p : items) {
            if (p instanceof Novel) novelCount++;
            else if (p instanceof Magazine) magazineCount++;
            else if (p instanceof ReferenceBook) refCount++;
        }
        int total = items.size();
        System.out.printf("잡지: %d권%n", magazineCount);
        System.out.printf("소설: %d권%n", novelCount);
        System.out.printf("참고서: %d권%n", refCount);
        System.out.printf("총 출판물: %d권%n", total);
    }

    // 실행 테스트
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // 장바구니 추가
        cart.addItem(new Magazine("마이크로소프트", "2007-10-01", 328, 9900, "매월"));
        cart.addItem(new Magazine("경영과컴퓨터", "2007-10-03", 316, 9000, "매월"));
        cart.addItem(new Novel("빠삐용", "2007-07-01", 396, 9800, "베르나르베르베르", "현대소설"));
        cart.addItem(new Novel("남한산성", "2007-04-14", 383, 11000, "김훈", "대하소설"));
        cart.addItem(new ReferenceBook("실용주의프로그래머", "2007-01-14", 496, 25000, "소프트웨어공학"));

        // 장바구니 출력
        cart.displayCart();

        // 장바구니 통계 출력
        cart.printStatistics();

        // 빠삐용 제거
        cart.removeItem("빠삐용");

        // 장바구니 출력
        cart.displayCart();
    }
}