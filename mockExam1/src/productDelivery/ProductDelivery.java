package productDelivery;

import java.util.ArrayList;
import java.util.List;

public class ProductDelivery {

    private List<Customer> myCustomerList= new ArrayList<>();
    private List<Product> productList = new ArrayList<>();
    private double deliveryCost = 15;


    public ProductDelivery(){}

    public List<Customer> getMyCustomerList() {
        return myCustomerList;
    }

    public void setMyCustomerList(Customer myCustomerList) {
        this.myCustomerList.add(myCustomerList);
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(Product product) {
        this.productList.add(product);
    }

    public double getDeliveryCost() {
        return deliveryCost;
    }

    public void setDeliveryCost(double deliveryCost) {
        this.deliveryCost = deliveryCost;
    }

    public void addProduct(String name, double price , int stock){
        Product newProduct =new Product(stock, name, price);
        setProductList(newProduct);
    }

    public void addParticularCustomer(String name,String address, String phone){
        ParticularCustomer customer = new ParticularCustomer(name,address,phone);
        setMyCustomerList(customer);
    }

    public void addBusinessCustomer(String fantasyName, String address, String phone, double discount){
        BusinessCustomer customer = new BusinessCustomer(fantasyName,address,phone,discount);
        setMyCustomerList(customer);
    }
    public Customer searchForCustomer(String name){
        for (Customer customer: myCustomerList ){
            if(customer.getName().equals(name)){
                return customer;
            }
        }
        return null;
    }

    public Product searchForProduct(String name){
        for (Product product: productList){
            if(product.getName().equals(name)){
                if(product.getStock() > 0) return product;
            }
        }
        return null;
    }
    public void createOrder(Customer customer, String name, double km){
        Product product=searchForProduct(name);
        Order order =new Order(product,km);
        for(Customer custom : myCustomerList){
            if(custom.equals(customer)){
                custom.setCustomerOrder(order);
            }
        }
    }

    public String showOrder(Customer customer,String name, double km){
        createOrder(customer,name,km);
        String message="";
        double totalPrice=0;
        for (Order customOrder : customer.getCustomerOrder()){
            customOrder.setTotalDelivery(this.deliveryCost);
            for(Product prodsOrder: customOrder.getTheProduct()){
                totalPrice+= prodsOrder.getPrice();
            }
            message= "Total cost is $"+(totalPrice+customOrder.getTotalDelivery())+ " Do you confirm order?";
        }
        return message;
    }
    

}
