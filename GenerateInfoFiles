import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GenerateInfoFiles {

    public static void main(String[] args) {
        try {
            createSalesMenFile(10, "SalesMenData", 1000);
            createProductsFile(20, "ProductsData");
            createSalesManInfoFile(10, "SalesManInfoData");
            System.out.println("Files generated successfully.");
        } catch (IOException e) {
            System.err.println("Error generating files: " + e.getMessage());
        }
    }

    public static void createSalesMenFile(int randomSalesCount, String name, long id) throws IOException {
        Random random = new Random();
        try (FileWriter writer = new FileWriter(name + ".txt")) {
            for (int i = 0; i < randomSalesCount; i++) {
                writer.write("Type" + ";" + id + "\n");
                for (int j = 1; j <= 3; j++) {
                    writer.write("Product" + j + ";" + (random.nextInt(10) + 1) + "\n");
                }
            }
        }
    }

    public static void createProductsFile(int productsCount, String name) throws IOException {
        try (FileWriter writer = new FileWriter(name + ".txt")) {
            for (int i = 1; i <= productsCount; i++) {
                writer.write("IDProduct" + i + ";ProductName" + i + ";" + (i * 10) + "\n");
            }
        }
    }

    public static void createSalesManInfoFile(int salesmanCount, String name) throws IOException {
        Random random = new Random();
        String[] firstNames = {"John", "Alice", "Michael", "Emma", "David", "Sophia"};
        String[] lastNames = {"Smith", "Johnson", "Brown", "Lee", "Taylor", "Wilson"};
        try (FileWriter writer = new FileWriter(name + ".txt")) {
            for (int i = 1; i <= salesmanCount; i++) {
                String firstName = firstNames[random.nextInt(firstNames.length)];
                String lastName = lastNames[random.nextInt(lastNames.length)];
                writer.write("Type" + ";" + (1000 + i) + ";" + firstName + " " + lastName + "\n");
            }
        }
    }
}
