package GuideIntro;

import java.util.Scanner;

public class task12 {
    static Scanner scan=new Scanner (System.in);
    public static void dekm_a_ms()
    {
        int kilometros;
        int metros;
        System.out.println("Ingrese los kilometros/hora que desee convetir a Metros/Segundos");
        kilometros=scan.nextInt();
        metros= (kilometros*1000)/3600;
        System.out.println(kilometros+" km/h = a "+metros+" m/s");

    }
}
