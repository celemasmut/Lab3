package guide1;

import guide1.util.Util;

import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args){
        char option;
       do{
           Util.exerciseMenu();
           option = scan.next().charAt(0);

           switch (option) {
               case 49:
                   Util.RectanguleClass();
                   break;
               case 50:
                   Util.employeeClass();
                   break;
               case 51:
                   Util.itemClass();
                   break;
               case 52:
                   Util.bankAccountClass();
                   break;
               case 53:
                   Util.hourClass();
                   break;
               default:
                   System.out.println("That operation does not exist");
                   break;
           }
           System.out.println("Press any key or s to exit");
            option = scan.next().charAt(0);
        }while (option!=115);
       System.out.println("You are out");
    }
}
