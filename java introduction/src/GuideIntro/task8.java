package GuideIntro;

import java.util.Scanner;

public class task8 {
    static Scanner scan= new Scanner (System.in);
    public static void greet_and_Name()
    {
        String nombre;
        System.out.println("Insert name here: ");
        nombre=scan.next();
        System.out.println("Good Morning "+nombre);
    }
}
