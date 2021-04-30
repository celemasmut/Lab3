package productDelivery;

public class BusinessCustomer extends Customer{

    public BusinessCustomer(String fantasyName, String address, String phone) {
       super(address,phone,fantasyName);
    }

    @Override
    public String toString() {
        return "Business Customer: "+
                super.toString() ;
    }


    @Override
    public double seeTotalSalePurchase(Order o) {
        return o.calculateTotal()-o.calculateTotalBusiness();
    }


}
