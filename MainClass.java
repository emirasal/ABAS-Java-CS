import java.util.*;

public class MainClass {

    private static final List<List<Object>> data = Arrays.asList(
            Arrays.asList(1000, 2000, 12, 100.51),
            Arrays.asList(1000, 2001, 31, 200.0),
            Arrays.asList(1000, 2002, 22, 150.86),
            Arrays.asList(1000, 2003, 41, 250.0),
            Arrays.asList(1000, 2004, 55, 244.0),
            Arrays.asList(1001, 2001, 88, 44.531),
            Arrays.asList(1001, 2002, 121, 88.11),
            Arrays.asList(1001, 2004, 74, 211.0),
            Arrays.asList(1001, 2002, 14, 88.11),
            Arrays.asList(1002, 2003, 2, 12.1),
            Arrays.asList(1002, 2004, 3, 22.3),
            Arrays.asList(1002, 2003, 8, 12.8),
            Arrays.asList(1002, 2002, 16, 94.0),
            Arrays.asList(1002, 2005, 9, 44.1),
            Arrays.asList(1002, 2006, 19, 90.0)
    );

    private static double calculateTotalPrice() {
        double totalSum = 0.0;

        for (List<Object> row : data) {
            int miktar = (int) row.get(2);
            double birimFiyat = ((Number) row.get(3)).doubleValue();

            double rowTotal = miktar * birimFiyat;
            totalSum += rowTotal;
        }

        return Math.round(totalSum * 100.0) / 100.0;
    }

    public static double calculateAveragePrice() {
        double sum = 0.0;
        int count = 0;


        for (List<Object> row : data) {
            double birimFiyat = ((Number) row.get(3)).doubleValue();

            sum += birimFiyat;
            count++;
        }

        return Math.round((sum / count) * 100.0 / 100.0);
    }

    public static Map<Integer, Double> calculateAverageByMalNumarasi() {
        Map<Integer, List<Double>> pricesByMalNumarasi = new HashMap<>();


        for (List<Object> row : data) {
            int malNumarasi = (Integer) row.get(1);
            double birimFiyat = ((Number) row.get(3)).doubleValue();

            pricesByMalNumarasi.computeIfAbsent(malNumarasi, k -> new ArrayList<>()).add(birimFiyat);
        }


        Map<Integer, Double> averageByMalNumarasi = new HashMap<>();
        for (Map.Entry<Integer, List<Double>> entry : pricesByMalNumarasi.entrySet()) {
            int malNumarasi = entry.getKey();
            List<Double> prices = entry.getValue();
            double average = prices.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
            averageByMalNumarasi.put(malNumarasi, average);
        }

        return averageByMalNumarasi;
    }

    public static void printMiktarForEachMal() {
        Map<Integer, Map<Integer, Integer>> miktarMap = new TreeMap<>();

        for (List<Object> row : data) {
            int siparis = (Integer) row.get(0);
            int malNumarasi = (Integer) row.get(1);
            int miktar = (Integer) row.get(2);

            miktarMap.computeIfAbsent(malNumarasi, k -> new TreeMap<>())
                    .put(siparis, miktar);
        }


        for (Map.Entry<Integer, Map<Integer, Integer>> entry : miktarMap.entrySet()) {
            int malNumarasi = entry.getKey();
            System.out.print("Mal Numarası " + malNumarasi + ": ");

            boolean first = true;
            for (Map.Entry<Integer, Integer> siparisEntry : entry.getValue().entrySet()) {
                if (!first) {
                    System.out.print(", ");
                }
                System.out.print("Sipariş " + siparisEntry.getKey() + " --> " + siparisEntry.getValue() + " Miktar");
                first = false;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("a. Toplam Tutar: " + calculateTotalPrice());
        System.out.println("b. Ortalama Fiyat: " + calculateAveragePrice());
        System.out.println("c. Mal Bazlı Ortalama: " + calculateAverageByMalNumarasi());
        System.out.println("d. Her Mal için Sipariş Miktarları:");
        printMiktarForEachMal();

    }

}
