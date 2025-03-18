import java.util.Arrays;

public class GaudiMitArraysV2 {
    public static void main(String[] args) {
        
        int howMuch = 3;

        // make and fill array
        char[] alphabet = new char[26];
        for (int i = 0; i < alphabet.length; i ++) {
            alphabet[i] = (char)('A'+i);
        }
        
        char[] shiftedArr = new char[26]; // create shifted array
        
        int shift1 = 26 - howMuch;
        if (howMuch > 0 ) {
            for (int i = 0; i < alphabet.length ^ shift1 == alphabet.length; i++) {
                shiftedArr[i] = alphabet[shift1];
                shift1++;
                System.out.println(Arrays.toString(shiftedArr));
            }
            for (int i = howMuch; i < alphabet.length; i++) {
                int a = i-howMuch;
                shiftedArr[i] = alphabet[a];
                System.out.println(Arrays.toString(shiftedArr));
            }
        }
        else {
            int a = alphabet.length + howMuch;
            int b = 0;
            int c = howMuch*(-1);

            for (int i = a; i < alphabet.length; i++) {
                shiftedArr[i] = alphabet[b];
                System.out.println(Arrays.toString(shiftedArr));
                b++;
            }
            for (int i = 0; i < alphabet.length ^ c == alphabet.length; i++) {
                shiftedArr[i] = alphabet[c];
                c++;
                System.out.println(Arrays.toString(shiftedArr));
            }
        }
    }
}