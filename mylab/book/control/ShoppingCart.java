package mylab.book.control;

import mylab.book.entity.Publication;
import mylab.book.entity.Novel;
import mylab.book.entity.Magazine;
import mylab.book.entity.ReferenceBook;
import java.util.*;

public class ShoppingCart {
    private List<Publication> items = new ArrayList<>();

    public ShoppingCart() {}

    // ������ �߰�
    public void addItem(Publication pub) {
        items.add(pub);
        System.out.println(pub.getTitle() + "��(��) ��ٱ��Ͽ� �߰��Ǿ����ϴ�.");
    }

    // ������ ����
    public boolean removeItem(String title) {
        for (Publication p : items) {
            if (p.getTitle().equals(title)) {
                items.remove(p);
                System.out.println(title + "��(��) ��ٱ��Ͽ��� ���ŵǾ����ϴ�.");
                return true;
            }
        }
        return false;
    }

    // ��ٱ��� ���
    public void displayCart() {
        System.out.println("====== ��ٱ��� ���� ======");
        int index = 1;
        for (Publication p : items) {
            System.out.printf("%d. %s - %,d��%n", index++, p.getTitle(), p.getPrice());
        }
        System.out.printf("�� ����: %,d��%n", calculateTotalPrice());
        System.out.printf("���� ���� ����: %,d��%n", calculateDiscountedPrice());
    }

    // �� ���� ���
    public int calculateTotalPrice() {
        int sum = 0;
        for (Publication p : items) {
            sum += p.getPrice();
        }
        return sum;
    }

    // ���� ���� ��� (��ü 15% ���� ����)
    public int calculateDiscountedPrice() {
        return (int)(calculateTotalPrice() * 0.85);
    }

    // ��ٱ��� ��� ���
    public void printStatistics() {
        System.out.println("====== ��ٱ��� ��� ======");
        int novelCount = 0, magazineCount = 0, refCount = 0;
        for (Publication p : items) {
            if (p instanceof Novel) novelCount++;
            else if (p instanceof Magazine) magazineCount++;
            else if (p instanceof ReferenceBook) refCount++;
        }
        int total = items.size();
        System.out.printf("����: %d��%n", magazineCount);
        System.out.printf("�Ҽ�: %d��%n", novelCount);
        System.out.printf("����: %d��%n", refCount);
        System.out.printf("�� ���ǹ�: %d��%n", total);
    }

    // ���� �׽�Ʈ
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // ��ٱ��� �߰�
        cart.addItem(new Magazine("����ũ�μ���Ʈ", "2007-10-01", 328, 9900, "�ſ�"));
        cart.addItem(new Magazine("�濵����ǻ��", "2007-10-03", 316, 9000, "�ſ�"));
        cart.addItem(new Novel("���߿�", "2007-07-01", 396, 9800, "����������������", "����Ҽ�"));
        cart.addItem(new Novel("���ѻ꼺", "2007-04-14", 383, 11000, "����", "���ϼҼ�"));
        cart.addItem(new ReferenceBook("�ǿ��������α׷���", "2007-01-14", 496, 25000, "����Ʈ�������"));

        // ��ٱ��� ���
        cart.displayCart();

        // ��ٱ��� ��� ���
        cart.printStatistics();

        // ���߿� ����
        cart.removeItem("���߿�");

        // ��ٱ��� ���
        cart.displayCart();
    }
}