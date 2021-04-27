package productDelivery;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Order implements Comparable<Order>{
    private UUID id;
    private List<Product> productList= new ArrayList<>();
    private double km;
    private boolean confirmation=false;
    private double totalDelivery=0;
    private int totalOrder=0;

    public Order(){}


    public Order(Product product, double km, double delivery) {
        this.id= UUID.randomUUID();
        this.km=km;
        productList.add(product);
        setTotalDelivery(delivery);
    }

    public List<Product> getTheProduct() {
        return productList;
    }

    public void setTheProduct(Product theProduct) {
        this.productList.add(theProduct) ;
    }

    public void setConfirmation(int confirmation) {
        if(confirmation == 1){
            this.confirmation=true;
        }else{
            this.confirmation=false;
        }
    }

    public boolean getConfirmation(){
        return this.confirmation;
    }

    public void setTotalDelivery(double deliveryCost) {
        this.totalDelivery = this.km*deliveryCost;
    }

    public void setTotalOrder(double price){
        this.totalOrder+= price;
    }

    public double getTotalOrder(){
        return totalOrder;
    }

    public double getTotalPrice(){
        return totalDelivery + totalOrder;
    }

    public double calculateTotal(){
        for (Product myProd: productList){
            setTotalOrder(myProd.getPrice());
        }
        return getTotalPrice();
    }
    public double calculateTotalBusiness(){
        return (getTotalPrice()*15)/100;
    }

    @Override
    public String toString() {
        return "Order{" +
                ", id=" + id +
                ", productList=" + productList +
                ", km=" + km +
                ", confirmation=" + confirmation +
                ", total order=" + totalOrder +
                ", total delivery =" + totalDelivery +
                '}';
    }

    @Override
    public int compareTo(Order o) {
        if(this.calculateTotal() < o.calculateTotal()){
            return -1;
        }
        return 0;
    }
}
