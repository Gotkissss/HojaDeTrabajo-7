import java.io.*;
import java.util.*;

// Nodo del BST
class Node {
    String sku;
    String productName;
    String category;
    double priceRetail;
    double priceCurrent;
    Node left, right;

    public Node(String sku, String productName, String category, double priceRetail, double priceCurrent) {
        this.sku = sku;
        this.productName = productName;
        this.category = category;
        this.priceRetail = priceRetail;
        this.priceCurrent = priceCurrent;
        this.left = this.right = null;
    }
}