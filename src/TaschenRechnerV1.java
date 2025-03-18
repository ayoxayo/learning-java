public class TaschenRechnerV1 {
    public static void main(String[] args) {
        int a = 9;
        int b = 4;

        double divide = (double) a / b;

        System.out.println("Erste Variable: " + a );
        System.out.println("Zweite Variable: " + b );
        System.out.println( a + " + " + b + " = " + (a + b) );
        System.out.println( a + " - " + b + " = " + (a - b) );
        System.out.println( a + " * " + b + " = " + (a * b) );
        System.out.println( a + " / " + b + " = " + divide );
        System.out.println( a + " % " + b + " = " + (a % b) );
    }
}