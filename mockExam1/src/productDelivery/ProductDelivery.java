package productDelivery;

import java.util.*;

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

    //The method adds a product to the product list
    public void addProduct(String name, double price , int stock){
        Product newProduct =new Product(stock, name, price);
        setProductList(newProduct);
    }
    //The method adds a Particular Customer to the customer list
    public void addParticularCustomer(String name,String address, String phone){
        ParticularCustomer customer = new ParticularCustomer(name,address,phone);
        setMyCustomerList(customer);
    }
    //The method adds a Business customer to the customer list
    public void addBusinessCustomer(String fantasyName, String address, String phone){
        BusinessCustomer customer = new BusinessCustomer(fantasyName,address,phone);
        setMyCustomerList(customer);
    }
    //The method search for a certain customer
    public Customer searchForCustomer(UUID id){
        for (Customer customer: myCustomerList ){
            if(customer.getId().equals(id)){
                return customer;
            }
        }
        return null;
    }

    //The method search for a certain product
    public Product searchForProduct(String name){
        for (Product product: productList){
            if(product.getName().equals(name))return product;
        }
        return null;
    }

    //checkea the product's stock
    public boolean checkStock(Product product){
        return product.getStock() > 0 ? true : false;
    }

    //The method create an order . It needs a product name and the km. it returns a message
    public Order createOrder( String name, double km) {
        Order order = null;
        if (checkStock(searchForProduct(name))) {
            System.out.println("Stock ok, order created");
            return order = new Order(searchForProduct(name), km, this.deliveryCost);
        }
        return null;
    }

//The method change stock ones the client confirm order
    public void changeProductStock(Order order){
        for(Product prud : order.getTheProduct()){
            prud.setStock(prud.getStock()-1);
            prud.setSold();
        }
    }

    public void addOrderToCustomer(Customer customer,Order order){
        for (Customer custom : myCustomerList) {
            if (custom.equals(customer)) {
                custom.setCustomerOrder(order);
                changeProductStock(order);
            }
        }
    }


    //The method gets the quantity of products sold
    public double getQuantitySold(){
        double quantity=0;
        for (Product myProduct: productList){
            quantity+= myProduct.getSold();
        }
        return quantity;
    }


    //the method returns the customer with more orders
    public Optional<Customer> showCustomerWithMoreOrders(){
        return myCustomerList.stream()
                .max(Comparator.comparing(Customer::seeTotalSalePurchase));
    }



}
