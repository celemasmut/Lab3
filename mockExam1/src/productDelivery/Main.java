package productDelivery;

import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        char option;
        ProductDelivery store = new ProductDelivery();
        do{
            System.out.println("Insert Name, address and phone for Particular customer\n");
            store.addParticularCustomer(scan.nextLine(), scan.nextLine(), scan.nextLine());
            scan.nextLine();
            System.out.println("\nInsert Name, address and phone and the discount for a Business customer\n");
            store.addBusinessCustomer(scan.nextLine(), scan.nextLine(), scan.nextLine(),scan.nextDouble());
            System.out.println("Press any key or 'e' to exit");
            option = scan.next().charAt(0);
        }while (option!=101);
        System.out.println("Enter for Product:");
        do{
            scan.nextLine();
            System.out.println("name:");
            String name= scan.nextLine();
            System.out.println("price:");
            double price = scan.nextDouble();
            System.out.println("stock:");
            int stock = scan.nextInt();
            store.addProduct(name, price, stock);
            System.out.println("Press any key or 'e' to exit");
            option = scan.next().charAt(0);
        }while (option!=101);

        System.out.println("Customers");
        store.getMyCustomerList().forEach(ob -> System.out.println(ob.getName()));
        System.out.println("select the customer");
        String name= scan.nextLine();
        Customer myCustomer = store.searchForCustomer(name);
        System.out.println("Products");
        store.getProductList().forEach(ob -> System.out.println(ob.getStock()>0 ? ob.toString():null));
        System.out.println("select the product");
        String prod = scan.nextLine();
        System.out.println("please enter the amount of km to deliver");
        double km= scan.nextDouble();

        System.out.println(store.showOrder(myCustomer,prod,km));


    }
}
