package productDelivery;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Order {
    private UUID id;
    private List<Product> productList= new ArrayList<>();
    private double km;
    private boolean confirmation=false;
    private double totalDelivery;


    public Order(Product product, double km) {
        this.id= UUID.randomUUID();
        this.km=km;
        productList.add(product);
    }

    public List<Product> getTheProduct() {
        return productList;
    }

    public void setTheProduct(Product theProduct) {
        this.productList.add(theProduct) ;
    }

    public double getKm() {
        return km;
    }

    public void setKm(double km) {
        this.km = km;
    }

    public boolean isConfirmation() {
        return confirmation;
    }

    public void setConfirmation(boolean confirmation) {
        this.confirmation = confirmation;
    }

    public double getTotalDelivery() {
        return totalDelivery;
    }

    public void setTotalDelivery(double deliveryCost) {
        this.totalDelivery = this.km*deliveryCost;
    }

    public UUID getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", productList=" + productList +
                ", km=" + km +
                ", confirmation=" + confirmation +
                ", total=" + totalDelivery +
                '}';
    }
}
