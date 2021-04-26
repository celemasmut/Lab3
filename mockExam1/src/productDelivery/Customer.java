package productDelivery;

import java.util.ArrayList;
import java.util.List;

public class Customer implements Comparable<Customer>{
     private  String address;
    private String phone;
     private String name;
     private List<Order> customerOrder=new ArrayList<>();


    public Customer(){}

    public Customer(String address, String phone, String name) {
        this.address = address;
        this.phone = phone;
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Order> getCustomerOrder() {
        return customerOrder;
    }

    public void setCustomerOrder(Order customerOrder) {
        this.customerOrder.add(customerOrder);
    }


    @Override
    public String toString() {
        return  "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", customerOrder=" + customerOrder;
    }

    @Override
    public int compareTo(Customer o) {
        if(o.getCustomerOrder().size() > this.customerOrder.size()){
            return -1;
        }
        return 0;
    }
}
