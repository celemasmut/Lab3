package GuideIntro;

import java.util.Scanner;

public class task11 {
    static Scanner scan=new Scanner (System.in);
    public static void long_y_area_de_circunf()
    {
        int radio;
        int longitud;
        int area;
        System.out.println("Ingrese el radio de lacircunferencia");
        radio=scan.nextInt();
        longitud=(int)(2*Math.PI*radio);
        area=(int)(Math.PI*Math.pow(radio, 2));
        System.out.println("La longitud de la circunferencia queda en: "+longitud);
        System.out.println("El area queda en: "+area);
    }
}
