package productDelivery;

public class ParticularCustomer extends Customer {


    public ParticularCustomer(){
        super();
    }

    public ParticularCustomer(String name,String address, String phone){
       super(address, phone, name);
    }

    @Override
    public String toString() {
        return "Particula Customer: "+ super.toString();
    }
}
