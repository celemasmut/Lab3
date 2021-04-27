package productDelivery;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Customer{
    private UUID id;
     private  String address;
    private String phone;
     private String name;
     private List<Order> customerOrder=new ArrayList<>();

     public Customer(){}

    public Customer(String address, String phone, String name) {
        this.address = address;
        this.phone = phone;
        this.name = name;
        setId();
    }

    public UUID getId() {
        return id;
    }

    public void setId() {
        this.id = UUID.randomUUID();
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
        return  "Id="+id + '\''+
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", customerOrder=" + customerOrder;
    }


}
