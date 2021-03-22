package GuideIntro;

import java.util.Scanner;

public class task13 {
    static Scanner scan= new Scanner (System.in);
    public static void trianrect_long_e_hipo()
    {
        int cat1, cat2;
        float hipo;
        System.out.println("Ingrese el primer cateto y luego el segundo cateto");
        cat1=scan.nextInt();
        cat2=scan.nextInt();
        hipo=(float) Math.sqrt(Math.pow(cat1, 2)+Math.pow(cat2, 2));
    }

}
