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
            if(product.getName().equals(name))return product;
        }
        return null;
    }

    public boolean checkStock(Product product){
        return product.getStock() > 0 ? true : false;
    }
    public String createOrder(Customer customer, String name, double km){
        String message;
        if(checkStock(searchForProduct(name))) {
            message="Stock ok, order will be created";
            Order order = new Order(searchForProduct(name), km);
            for (Customer custom : myCustomerList) {
                if (custom.equals(customer)) {
                    custom.setCustomerOrder(order);
                    searchForProduct(name).setStock(searchForProduct(name).getStock() - 1);
                    searchForProduct(name).setSold();
                }
            }
        }else {
            message="Run out stock, can not take this order";
        }
        return message;
    }

    public String setCostOrder(Customer customer,String name, double km){
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

    public double getQuantitySold(){
        double quantity=0;
        for (Product myProduct: productList){
            quantity+= myProduct.getSold();
        }
        return quantity;
    }

    public double averageTotalSold(){
        String message="";
        double totalCost=0;
        double averageTotal=0;
        for(Customer myCustomer : myCustomerList){
            for(Order custOrder : myCustomer.getCustomerOrder()){
                totalCost+= custOrder.getTotalDelivery();
            }
            averageTotal=totalCost/getQuantitySold();
        }
        return averageTotal;
    }


    public Customer showCustomerWithMoreOrders(){
        double aux1=0;
        double aux2=0;
        for (Customer myCustomer:myCustomerList){
            for(Order custOrder : myCustomer.getCustomerOrder()){
                custOrder.calculateTotal();
                aux1 += custOrder.getTotalOrder();
            }
        }
        return null;
    }



}
