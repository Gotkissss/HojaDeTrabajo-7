import java.io.*;
import java.util.*;

public class ProductSearch {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        String csvFile = "Escritorio/Hoja de trabajo #7/archive/skus lowes.csv";
        String line;
        String splitBy = ",";
        
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            br.readLine(); // Saltar encabezado
            while ((line = br.readLine()) != null) {
                String[] data = line.split(splitBy);
                if (data.length >= 5) {
                    String sku = data[0].trim();
                    double priceRetail = Double.parseDouble(data[1].trim());
                    double priceCurrent = Double.parseDouble(data[2].trim());
                    String productName = data[3].trim();
                    String category = data[4].trim();
                    bst.insert(sku, productName, category, priceRetail, priceCurrent);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Búsqueda de SKU
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el SKU a buscar: ");
        String searchSku = scanner.nextLine();
        Node result = bst.search(searchSku);
        
        if (result != null) {
            System.out.println("Producto encontrado:");
            System.out.println("SKU: " + result.sku);
            System.out.println("Nombre: " + result.productName);
            System.out.println("Categoría: " + result.category);
            System.out.println("Precio Retail: " + result.priceRetail);
            System.out.println("Precio Actual: " + result.priceCurrent);
        } else {
            System.out.println("Producto no encontrado.");
        }
    }
}
