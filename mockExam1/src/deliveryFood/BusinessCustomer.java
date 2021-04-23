package deliveryFood;

public class BusinessCustomer {
    private String fantasyName;
    private String address;
    private String phone;
    private double discount;

    public BusinessCustomer(){}

    public BusinessCustomer(String fantasyName, String address, String phone, double discount) {
        this.fantasyName = fantasyName;
        this.address = address;
        this.phone = phone;
        this.discount = discount;
    }

    public String getFantasyName() {
        return fantasyName;
    }

    public void setFantasyName(String fantasyName) {
        this.fantasyName = fantasyName;
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

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
