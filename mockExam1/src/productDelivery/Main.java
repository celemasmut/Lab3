package productDelivery;

import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        ProductDelivery store = new ProductDelivery();
       //adding two type of customers
        System.out.println("Insert Name, address and phone for Particular customer\n");
        store.addParticularCustomer(scan.nextLine(), scan.nextLine(), scan.nextLine());
        scan.nextLine();
        System.out.println("\nInsert Name, address and phone and the discount for a Business customer\n");
        store.addBusinessCustomer(scan.nextLine(), scan.nextLine(), scan.nextLine());

        // adding a product
        System.out.println("Enter for Product:");
        System.out.println("name:");
        String name= scan.nextLine();
        System.out.println("price:");
        double price = scan.nextDouble();
        System.out.println("stock:");
        int stock = scan.nextInt();
        store.addProduct(name, price, stock);

        //Customers
        store.addParticularCustomer("Lucho","casa333","838383883");
        store.addParticularCustomer("Dani","casa999","88585885");
        store.addParticularCustomer("Noah","casa444","2727272");
        store.addBusinessCustomer("Edif","calle5555","12121212");
        store.addBusinessCustomer("Edif2","calle2","11111119");
        store.addBusinessCustomer("Edif5","calle5","88888883");
        //

        //
        store.addProduct("Cocacola",200,5);
        store.addProduct("milk",90,30);
        store.addProduct("cookies", 150,17);
        store.addProduct("water",100,20);
        //
        System.out.println("Customers");
        store.getMyCustomerList().forEach(ob -> System.out.println(ob.getName()));
        System.out.println("Select the customer that takes the order");
        name= scan.nextLine();
        Customer myCustomer = store.searchForCustomer(name);
        System.out.println("Products");
        store.getProductList().forEach(ob -> System.out.println(ob.getStock()>0 ? ob.toString():null));
        System.out.println("select the product");
        name = scan.nextLine();
        System.out.println("please enter the amount of km to deliver");
        double km= scan.nextDouble();

        Order customerOrder = store.createOrder(name,km);
        store.searchForProduct("Cocacola");
        store.searchForProduct("milk");
        System.out.println("customer confirm order? yes = 1 / No = 0");
        customerOrder.setConfirmation(scan.nextInt());
        if(customerOrder.getConfirmation()){
            store.addOrderToCustomer(myCustomer,customerOrder);
            int totalPrice=0;
            for(Product prod :customerOrder.getTheProduct()){
                totalPrice += prod.getPrice();
            }
            System.out.println("total is: $"+ customerOrder.getTotalDelivery() + totalPrice );
        }else{
            System.out.println("customer does not confirm order");
        }



    }
}
