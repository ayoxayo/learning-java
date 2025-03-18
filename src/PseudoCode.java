public class PseudoCode {
    public static void main(String[] args) {
        int n = 22;
        boolean prim = true;
        //
        for (int x = 2; x <= (n-1); x++) {
            if (n % x == 0) {
                prim = false;
            }
        }
        if (prim) {
            System.out.println("Ist Primzahl");
        } else {
            System.out.println("Ist nicht Primzahl");
        }
    }
}
