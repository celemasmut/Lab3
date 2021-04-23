package productDelivery;

public class BusinessCustomer extends Customer{
    private double discount;

    public BusinessCustomer(){
        super();
    }

    public BusinessCustomer(String fantasyName, String address, String phone, double discount) {
       super(address,phone,fantasyName);
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Business Customer: "+
                super.toString() +
                "discount=" + discount ;
    }
}
