import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class GenerateInfoFiles {

    // Existing code remains unchanged...

    /**
     * Generates a file with pseudo-random salesmen data.
     *
     * @param filename         The name of the salesmen information file to
     *                         generate.
     * @param randomSalesCount The number of sales entries to generate.
     * @param name             The name of the salesman.
     * @param id               The ID of the salesman.
     */
    public static void createSalesMenFile(String filename, int randomSalesCount, String name, long id) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));

            // Generate pseudo-random sales data for the salesman and write it to the file
            Random random = new Random();
            for (int i = 0; i < randomSalesCount; i++) {
                int randomValue = random.nextInt(1000); // Example of pseudo-random sales value between 0 and 999
                writer.write(name + ";" + id + ";" + randomValue);
                writer.newLine();
            }

            writer.close();
            System.out.println("Salesmen information file generated successfully.");
        } catch (IOException e) {
            System.err.println("Error writing to salesmen information file: " + e.getMessage());
        }
    }

    /**
     * Generates a file with pseudo-random product data.
     *
     * @param filename      The name of the products information file to generate.
     * @param productsCount The number of product entries to generate.
     */
    public static void createProductsFile(String filename, int productsCount) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));

            // Generate pseudo-random product data and write it to the file
            Random random = new Random();
            for (int i = 0; i < productsCount; i++) {
                int randomPrice = random.nextInt(1000); // Example of pseudo-random price between 0 and 999
                writer.write("Product" + (i + 1) + ";" + randomPrice);
                writer.newLine();
            }

            writer.close();
            System.out.println("Products information file generated successfully.");
        } catch (IOException e) {
            System.err.println("Error writing to products information file: " + e.getMessage());
        }
    }

    /**
     * Generates a file with pseudo-random salesmen information.
     *
     * @param filename      The name of the salesmen information file to generate.
     * @param salesmanCount The number of salesmen entries to generate.
     */
    public static void createSalesManInfoFile(String filename, int salesmanCount) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));

            // Generate pseudo-random salesman information and write it to the file
            Random random = new Random();
            for (int i = 0; i < salesmanCount; i++) {
                long randomId = random.nextLong(); // Example of pseudo-random ID
                writer.write("Salesman" + (i + 1) + ";" + randomId);
                writer.newLine();
            }

            writer.close();
            System.out.println("Salesmen info file generated successfully.");
        } catch (IOException e) {
            System.err.println("Error writing to salesmen info file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Original code remains unchanged...

        // Generate salesmen information file
        createSalesManInfoFile("salesmen_info.txt", 5);

        // Generate products information file
        createProductsFile("products_info.txt", 4);

        // Generate salesmen data file
        createSalesMenFile("sales_data.txt", 10, "John Doe", 1234567890);
    }
}
