package mylab.book.control;

import mylab.book.entity.Publication;
import mylab.book.entity.Novel;
import mylab.book.entity.Magazine;
import mylab.book.entity.ReferenceBook;
import java.util.*;

public class StatisticsAnalyzer {

    public Map<String, Double> calculateAveragePriceByType(Publication[] publications) {
        Map<String, List<Integer>> prices = new HashMap<>();
        for (Publication p : publications) {
            String type = getPublicationType(p);
            prices.putIfAbsent(type, new ArrayList<>());
            prices.get(type).add(p.getPrice());
        }

        Map<String, Double> result = new HashMap<>();
        for (String type : prices.keySet()) {
            double avg = prices.get(type).stream().mapToInt(Integer::intValue).average().orElse(0);
            result.put(type, avg);
        }
        return result;
    }

    public Map<String, Double> calculatePublicationDistribution(Publication[] publications) {
        Map<String, Integer> counts = new HashMap<>();
        for (Publication p : publications) {
            String type = getPublicationType(p);
            counts.put(type, counts.getOrDefault(type, 0) + 1);
        }

        Map<String, Double> result = new HashMap<>();
        int total = publications.length;
        for (String type : counts.keySet()) {
            result.put(type, (counts.get(type) * 100.0) / total);
        }
        return result;
    }

    public double calculatePublicationRatioByYear(Publication[] publications, String year) {
        int total = publications.length;
        int count = 0;
        for (Publication p : publications) {
            if (p.getPublishDate().startsWith(year)) count++;
        }
        return total == 0 ? 0 : (count * 100.0) / total;
    }

    public String getPublicationType(Publication pub) {
        if (pub instanceof Novel) return "�Ҽ�";
        if (pub instanceof Magazine) return "����";
        if (pub instanceof ReferenceBook) return "����";
        return "��Ÿ";
    }

    public void printStatistics(Publication[] publications) {
        System.out.println("1. Ÿ�Ժ� ��� ����: ");
        Map<String, Double> avgPrices = calculateAveragePriceByType(publications);
        for (String type : avgPrices.keySet()) {
            System.out.printf("   - %s: %,d��\n", type, avgPrices.get(type).intValue());
        }
        System.out.println("2. ���ǹ� ���� ����(�����): ");
        Map<String, Double> distribution = calculatePublicationDistribution(publications);
        for (String type : distribution.keySet()) {
            System.out.printf("   - %s: %.2f%%%n", type, distribution.get(type));
        }
        
        System.out.println("\n3. 2007�⿡ ���ǵ� ���ǹ� ����: " 
                + String.format("%.2f", calculatePublicationRatioByYear(publications, "2007")) + "%");
        }
}