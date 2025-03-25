public class Product implements Comparable<Product> {
    private String sku;
    private String name;
    private double priceRetail;
    private double priceCurrent;
    private String category;
    
    public Product(String sku, String name, double priceRetail, double priceCurrent, String category) {
        this.sku = sku;
        this.name = name;
        this.priceRetail = priceRetail;
        this.priceCurrent = priceCurrent;
        this.category = category;
    }
    
    public String getSku() { return sku; }
    public String getName() { return name; }
    public double getPriceRetail() { return priceRetail; }
    public double getPriceCurrent() { return priceCurrent; }  // NUEVO
    public String getCategory() { return category; }
    
    @Override
    public int compareTo(Product other) {
        return this.sku.compareTo(other.sku);
    }
    
    @Override
    public String toString() {
        return "SKU: " + sku + ", Nombre: " + name + ", Precio Retail: $" + priceRetail +
               ", Precio Actual: $" + priceCurrent + ", Categoría: " + category;
    }
}
