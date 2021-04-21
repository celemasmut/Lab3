package videoStore;

import java.util.ArrayList;
import java.util.UUID;

public class Customer {
    private UUID id;
    private String name;
    private String phone;
    private String address;
    private ArrayList<Rental>customerRentals = new ArrayList<>();

    public Customer(String name,String phone,String address){
        this.name=name;
        this.phone=phone;
        this.address=address;
        setId();
    }

    public ArrayList<Rental> getCustomerRentals() {
        return customerRentals;
    }
    public void setCustomerRentals(Rental rental) {
        this.customerRentals.add(rental);
    }

    public UUID getId() {
        return id;
    }

    private void setId() {
        this.id = UUID.randomUUID();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", customerRentals=" + customerRentals +
                '}';
    }
}
