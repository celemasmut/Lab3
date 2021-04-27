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
}
