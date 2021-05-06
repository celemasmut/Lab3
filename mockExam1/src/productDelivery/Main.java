package productDelivery;

import java.util.Scanner;
import java.util.UUID;

public class Main {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        ProductDelivery store = new ProductDelivery();
       //adding two type of customers
      /*  System.out.println("Insert Name, address and phone for Particular customer\n");
        store.addParticularCustomer(scan.nextLine(), scan.nextLine(), scan.nextLine());
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
        store.addProduct(name, price, stock);*/

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
        store.getMyCustomerList().forEach(ob -> System.out.println("ID:"+ob.getId() + "name: "+ob.getName()));
        System.out.println("Select the customer's id that takes the order");
        UUID idcust = UUID.fromString(scan.next());
        scan.nextLine();
        Customer myCustomer = store.searchForCustomer(idcust);
        System.out.println("Products");
        store.getProductList().forEach(ob -> System.out.println(ob.getStock()>0 ? ob.toString():null));
        System.out.println("select the product");
        String name = scan.nextLine();
        System.out.println("please enter the amount of km to deliver");
        double km= scan.nextDouble();

        //order1
        double average=0;
        double total=0;


        Order customerOrder = store.createOrder(name,km);
        customerOrder.setTheProduct(store.searchForProduct("Cocacola"));
        System.out.println("customer confirm order? yes = 1 / No = 0");
        customerOrder.setConfirmation(scan.nextInt());
        if(customerOrder.getConfirmation()){
            store.addOrderToCustomer(myCustomer,customerOrder);
            total= myCustomer.seeTotalSalePurchase(customerOrder);
            average+=total;
            System.out.println("total is: $"+ total );
        }else{
            System.out.println("customer does not confirm order");
        }

        //order2



        myCustomer=store.getMyCustomerList().get(2);
        customerOrder = store.createOrder("water",5);
        customerOrder.setTheProduct(store.searchForProduct("cookies"));
        customerOrder.setTheProduct(store.searchForProduct("milk"));
        customerOrder.setTheProduct(store.searchForProduct("cookies"));



        customerOrder.setConfirmation(1);
        if(customerOrder.getConfirmation()){
            store.addOrderToCustomer(myCustomer,customerOrder);
            total=myCustomer.seeTotalSalePurchase(customerOrder);
            System.out.println("total is: $"+ total);
            average+=total;
        }else{
            System.out.println("customer does not confirm order");
        }


        //oder3


        myCustomer=store.getMyCustomerList().get(4);
        customerOrder = store.createOrder("milk",23);
        customerOrder.setTheProduct(store.searchForProduct("cookies"));
        customerOrder.setTheProduct(store.searchForProduct("cookies"));
        customerOrder.setConfirmation(1);
        if(customerOrder.getConfirmation()){
            store.addOrderToCustomer(myCustomer,customerOrder);
            total=myCustomer.seeTotalSalePurchase(customerOrder);
            System.out.println("total is: $"+ total );
            average+=total;
        }else{
            System.out.println("customer does not confirm order");
        }

        store.getMyCustomerList().forEach(ob-> System.out.println(ob.toString()));

       System.out.println("The customer with more sales based on the cost "+store.showCustomerWithMoreOrders().toString());


        System.out.println("today's average sales: $"+(average/store.getQuantitySold()));

    }
}
