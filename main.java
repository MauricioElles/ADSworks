import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try {
            processSalesData("SalesMenData.txt", "SalesManInfoData.txt", "ProductsData.txt");
            System.out.println("Files created successfully.");
        } catch (IOException e) {
            System.err.println("Error processing data: " + e.getMessage());
        }
    }

    public static void processSalesData(String salesFile, String salesManInfoFile, String productsFile) throws IOException {
        Map<String, Integer> salesData = new HashMap<>();
        Map<String, Integer> productSales = new HashMap<>();

        // Read sales data
        try (BufferedReader reader = new BufferedReader(new FileReader(salesFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                String salesmanId = parts[1];
                int totalSales = salesData.getOrDefault(salesmanId, 0);
                for (int i = 2; i < parts.length; i += 2) {
                    totalSales += Integer.parseInt(parts[i]) * Integer.parseInt(parts[i + 1]);
                }
                salesData.put(salesmanId, totalSales);
            }
        }

        // Read salesman info
        Map<String, String> salesmanInfo = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(salesManInfoFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                salesmanInfo.put(parts[1], parts[2]);
            }
        }

        // Read product info
        Map<String, String> productInfo = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(productsFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                productInfo.put(parts[0], parts[1]);
            }
        }

        // Sort and write sales data
        List<Map.Entry<String, Integer>> sortedSalesData = new ArrayList<>(salesData.entrySet());
        sortedSalesData.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        try (PrintWriter writer = new PrintWriter(new FileWriter("SalesReport.csv"))) {
            for (Map.Entry<String, Integer> entry : sortedSalesData) {
                writer.println(salesmanInfo.get(entry.getKey()) + ";" + entry.getValue());
            }
        }

        // Calculate product sales
        for (String salesmanId : salesData.keySet()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(salesFile))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(";");
                    if (parts[1].equals(salesmanId)) {
                        for (int i = 2; i < parts.length; i += 2) {
                            String productId = parts[i];
                            int quantity = Integer.parseInt(parts[i + 1]);
                            int totalQuantity = productSales.getOrDefault(productId, 0);
                            productSales.put(productId, totalQuantity + quantity);
                        }
                    }
                }
            }
        }

        // Sort and write product sales
        List<Map.Entry<String, Integer>> sortedProductSales = new ArrayList<>(productSales.entrySet());
        sortedProductSales.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        try (PrintWriter writer = new PrintWriter(new FileWriter("ProductSales.csv"))) {
            for (Map.Entry<String, Integer> entry : sortedProductSales) {
                writer.println(productInfo.get(entry.getKey()) + ";" + entry.getValue() * Integer.parseInt(productInfo.get(entry.getKey()).split(";")[2]));
            }
        }
    }
}
