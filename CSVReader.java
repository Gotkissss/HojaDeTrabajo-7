import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {
    public static void loadProducts(String filePath, BinarySearchTree tree) {
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine(); // Saltar encabezado

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                if (data.length < 19) { // Revisar que tenga suficientes columnas
                    System.err.println("Línea inválida: " + line);
                    continue;
                }

                try {
                    String category = data[0].trim();
                    String sku = data[6].trim();
                    String brand = data[8].trim();
                    double priceRetail = parsePrice(data[9]);
                    double priceCurrent = parsePrice(data[10]);
                    String productName = data[18].trim();

                    Product product = new Product(sku, productName, priceRetail, priceCurrent, category);
                    tree.insert(product);
                } catch (NumberFormatException e) {
                    System.err.println("Error de formato en línea: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo CSV: " + e.getMessage());
        }
    }

    private static double parsePrice(String priceStr) {
        try {
            return Double.parseDouble(priceStr.trim());
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }
}
