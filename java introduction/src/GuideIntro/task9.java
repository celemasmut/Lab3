package GuideIntro;

import java.util.Scanner;

public class task9 {
    static Scanner scan= new Scanner (System.in);
    public static void numero_doble_triple()
    {
        int numero, doble, triple;
        System.out.println("ingrese un numero cualquiera");
        numero=scan.nextInt();
        doble=doble(numero);
        System.out.println("El doble del "+numero+" es: "+doble);
        triple=triple(numero);
        System.out.println("El triple del "+numero+" es: "+triple);

    }
    public static int doble(int x )
    {
        int doble= x*2;
        return doble;
    }
    public static int triple(int c)
    {
        int triple= c*3;
        return triple;
    }
}
