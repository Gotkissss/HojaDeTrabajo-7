class BinarySearchTree {
    private Node root;

    public void insert(String sku, String productName, String category, double priceRetail, double priceCurrent) {
        root = insertRec(root, sku, productName, category, priceRetail, priceCurrent);
    }

    private Node insertRec(Node root, String sku, String productName, String category, double priceRetail, double priceCurrent) {
        if (root == null) return new Node(sku, productName, category, priceRetail, priceCurrent);
        if (sku.compareTo(root.sku) < 0) root.left = insertRec(root.left, sku, productName, category, priceRetail, priceCurrent);
        else if (sku.compareTo(root.sku) > 0) root.right = insertRec(root.right, sku, productName, category, priceRetail, priceCurrent);
        return root;
    }

    public Node search(String sku) {
        return searchRec(root, sku);
    }

    private Node searchRec(Node root, String sku) {
        if (root == null || root.sku.equals(sku)) return root;
        return (sku.compareTo(root.sku) < 0) ? searchRec(root.left, sku) : searchRec(root.right, sku);
    }
}