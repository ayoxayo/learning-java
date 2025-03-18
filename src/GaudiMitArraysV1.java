import java.util.Arrays;
import java.util.Random;

public class GaudiMitArraysV1 {
    public static void main(String[] args) {
        // first array
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(Arrays.toString(a));
        // second array
        Random r = new Random();
        int[] b = new int[100];
        for (int i = 0; i < b.length; i++) { // start from 0, we're writing to 0 already
            b[i] = r.nextInt(100); // don't forget to limit the output, excluding the number itself / also from exists, as the a minimum value, including itself
        }
        
        char[] alphabet = new char[26];
        for (int i = 0; i < alphabet.length; i++)
            alphabet[i] = (char)('A'+i);
        // random array
        System.out.println(Arrays.toString(b));
        boolean[] c = new boolean[10]; // always false when not defined otherwise
        for (int x = 1; x < c.length; x++) { // write not to 0, due to -1
        c[x] = !c[x-1];
        // System.out.println(c[x]);
        }
        System.out.println(Arrays.toString(c));
        System.out.println(Arrays.toString(alphabet));
    }
}
