public class KleinerAlgorithmusV1 {
    public static void main(String[] args) {
        int a = 1;
        int b = 1;
        int c = 0;
        int counter = 60;
        //
        for (int counterRnd = 1; counterRnd <= counter; counterRnd++) {
            c = a + b;
            System.out.println(a + " + " + b + " = " + c);
            a = b;
            b = c;
        }
    }
}
