package guide2;

import guide2.utilities.Utilities;

import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args){
        char option;
        do{
            Utilities.exerciseMenu();
            option = scan.next().charAt(0);

            switch (option) {
                case 49:
                    Utilities.bookClass();
                    break;
                case 50:
                    Utilities.salesControl();
                    break;
                case 51:
                    Utilities.bankAccount();
                    break;
                default:
                    System.out.println("That operation does not exist");
                    break;
            }
            System.out.println("Press any key or 'e' to exit");
            option = scan.next().charAt(0);
        }while (option!=101);
    }
}
