package deliveryFood;

public class Product {
    private int stock;
    private String name;
    private double price;

    public Product(int stock, String name, double price) {
        this.stock = stock;
        this.name = name;
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
