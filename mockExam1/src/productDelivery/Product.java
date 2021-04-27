package productDelivery;

public class Product {
    private int stock;
    private String name;
    private double price;
    private int sold=0;

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


    public double getPrice() {
        return price;
    }

    public int getSold() {
        return sold;
    }

    public void setSold() {
        this.sold++;
    }

    @Override
    public String toString() {
        return "Product{" +
                "stock=" + stock +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
