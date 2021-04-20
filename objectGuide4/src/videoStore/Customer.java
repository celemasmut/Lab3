package videoStore;

import java.util.UUID;

public class Customer {
    private UUID id;
    private String name;
    private String phone;
    private String address;

    public Customer(String name,String phone,String address){
        this.name=name;
        this.phone=phone;
        this.address=address;
        setId();
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
}
