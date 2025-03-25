import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {
    private class Node {
        String sku;
        List<Product> products;
        Node left, right;

        public Node(Product product) {
            this.sku = product.getSku();
            this.products = new ArrayList<>();
            this.products.add(product);
            left = right = null;
        }
    }

    private Node root;

    public void insert(Product product) {
        root = insertRec(root, product);
    }

    private Node insertRec(Node root, Product product) {
        if (root == null) {
            return new Node(product);
        }
        int compare = product.getSku().compareTo(root.sku);
        if (compare < 0) {
            root.left = insertRec(root.left, product);
        } else if (compare > 0) {
            root.right = insertRec(root.right, product);
        } else {
            root.products.add(product); // Si el SKU ya existe, agregar a la lista
        }
        return root;
    }

    public Product searchBestPrice(String sku) {
        Node result = searchRec(root, sku);
        if (result == null) return null;

        Product bestProduct = result.products.get(0);
        for (Product p : result.products) {
            if (p.getPriceCurrent() < bestProduct.getPriceCurrent()) {
                bestProduct = p;
            }
        }
        return bestProduct;
    }

    private Node searchRec(Node root, String sku) {
        if (root == null || root.sku.equals(sku)) {
            return root;
        }
        return (sku.compareTo(root.sku) < 0) ? searchRec(root.left, sku) : searchRec(root.right, sku);
    }
}
