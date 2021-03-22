package guide1.util;

import guide1.exc1.Rectangle;
import guide1.exc2.Employee;
import guide1.exc3.Item;
import guide1.exc4.BankAccount;
import guide1.exc5.Hour;

import java.util.Scanner;

public class Util {
    static Scanner scan = new Scanner(System.in);


    public static void  exerciseMenu() {
        System.out.println("[1] Rectangle");
        System.out.println("[2] Employee");
        System.out.println("[3] Item on sale");
        System.out.println("[4] Bank Account");
        System.out.println("[5] Hour");
    }

    public static void RectanguleClass(){
        Rectangle myrectangle=new Rectangle(2.3f, 1.5f);
        System.out.println(myrectangle.printHeightAndWidth());
        System.out.println(myrectangle.printPerimeterAndArea());
        System.out.println("Insert new height and width");
        float height,width;
        height=scan.nextFloat();
        width=scan.nextFloat();
        myrectangle.modifyHeightAndWidth(height, width);
        System.out.println(myrectangle.printPerimeterAndArea());
        Rectangle mySecondR=new Rectangle();
        System.out.println(mySecondR.printHeightAndWidth());

    }
     public static void employeeClass(){
         Employee employee1=new Employee(23456345 ,"Carlos Gutierrez", 25000);
         Employee employee2=new Employee(34234123 ,"Ana Sanchez",27500);
         System.out.println(employee1.toString());
         System.out.println(employee2.toString());
         employee1.increaseSalary(15);
         double annualSalary;
         annualSalary=employee1.annualSalary();
         System.out.println(employee1);
         System.out.println("Annual Salary: $" +annualSalary);
     }

     public static void itemClass(){
         Item product1=new Item("Chocolate", 8, 73.5);
         System.out.println(product1.toString());
         Item product2=new Item();
         //trying id counter
         System.out.println(product2.toString());

     }

     public static void bankAccountClass(){
         BankAccount myAccount=new BankAccount(543,"Celeste Masmut",15000);
         myAccount.ToDeposit(2500);
         System.out.println(myAccount.toString());
         System.out.println(myAccount.ToExtract(1500));
         System.out.println(myAccount.ToExtract(30000));
         System.out.println(myAccount.toString());
     }

     public static void hourClass(){
         Hour myClock=new Hour(13,4,22);
         System.out.println(myClock.printTime());
         myClock.addSecond();
         System.out.println(myClock.printTime());
         Hour myClock2=new Hour(1,0,0);
         System.out.println(myClock2.printTime());
         myClock2.takeOutSecond();
         System.out.println(myClock2.printTime());
     }

}
