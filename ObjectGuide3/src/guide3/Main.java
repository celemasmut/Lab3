package guide3;

import guide3.util.Util;

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
                    Util.circleClass();
                    break;
                case 50:
                    Util.collegeClass();
                    break;
                case 51:
                    Util.geometricFiguresClass();
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
