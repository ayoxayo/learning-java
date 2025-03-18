import java.util.Scanner;

public class EinMalEinsV2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welche Reihe soll ausgegeben werden?");

        int b = sc.nextInt();
        int a = 1;

        System.out.println( a + " x " + b + " = " + ( a * b ) );
        a++;
        System.out.println( a + " x " + b + " = " + ( a * b ) );
        a++;
        System.out.println( a + " x " + b + " = " + ( a * b ) );
        a++;
        System.out.println( a + " x " + b + " = " + ( a * b ) );
        a++;
        System.out.println( a + " x " + b + " = " + ( a * b ) );
        a++;
        System.out.println( a + " x " + b + " = " + ( a * b ) );
        a++;
        System.out.println( a + " x " + b + " = " + ( a * b ) );
        a++;
        System.out.println( a + " x " + b + " = " + ( a * b ) );
        a++;
        System.out.println( a + " x " + b + " = " + ( a * b ) );
        a++;
        System.out.println( a + " x " + b + " = " + ( a * b ) );

        sc.close();
    }
}
