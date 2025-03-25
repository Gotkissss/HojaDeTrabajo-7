import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        String csvFile = "skus_lowes.csv";

        CSVReader.loadProducts(csvFile, tree);
        System.out.println("Productos cargados en el BST.");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el SKU a buscar: ");
        String sku = scanner.nextLine();

        Product bestProduct = tree.searchBestPrice(sku);
        if (bestProduct != null) {
            System.out.println("Producto encontrado con el mejor precio:");
            System.out.println(bestProduct);
        } else {
            System.out.println("Producto no encontrado.");
        }

        scanner.close();
    }
}
