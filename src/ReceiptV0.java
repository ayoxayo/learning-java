public class ReceiptV0 {
    public static void main(String[] args) {
        System.out.println(String.format("My name is %s.", "Testing"));
        System.out.println(String.format("Today is day %d of the month %d.", 3, 6));

        // int a = 34;
        // int b = 12;
        // System.out.println(String.format("%d + %d = %d", a, b, (a + b)));

        // int a = 34;
        // double b = 12;
        // System.out.println(String.format("%d + %.2f = %f", a, b, (a + b)));

        // int n1 = 6;
        // double n2 = 3;
        // double n3 = 14;
        // System.out.println(String.format("%d * %7.2f = %4.2f", n1, n2, (n1*n2)));
        // System.out.println(String.format("%d * %7.2f = %4.2f", n1, n3, (n1*n3)));
        // System.out.println(String.format("%d * %-1.2f = %8.2f", n1, n2, (n1*n2)));
        // int c = 2;
        // int d = 5;
        // int e = 12;
        // String formatter = "%d * %3d = %5d";
        // System.out.println(String.format(formatter, a, b, (a*b)));
        // System.out.println(String.format(formatter, a, c, (a*c)));
        // System.out.println(String.format(formatter, a, d, (a*d)));
        // System.out.println(String.format(formatter, a, e, (a*e)));
        

        String fl = "Flowers";
        String br = "Bread";
        String su = "Sugar";
        String ap = "Apple";
        double p1 = 1;
        double p2 = 2;
        double p3 = 3;
        double p4 = 4;
        int a1 = 1;
        int a2 = 2;
        int a3 = 3;
        int a4 = 4;
        String t = "Total:";
        System.out.println("-------------------------------");
        String formatterReceipt = "%s %7d * %.2f \n%24.2f\n";
        System.out.printf(formatterReceipt, fl, a1, p1, (a1 * p1));
        System.out.printf(formatterReceipt, br, a2, p2, (a2*p2));
        System.out.printf(formatterReceipt, su, a3, p3, (a3*p3));
        System.out.printf(formatterReceipt, ap, a4, p4, (a4*p4));
        System.out.println("----------------------------------");
        System.out.printf("%s %6.2f", t, (a1 * p1 + a2 * p2 + a3 * p3 + a4 * p4));
    }
}
