import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class CyberSecurityV1 {
    public static void main(String[] args) {
        Random r = new Random();
        Scanner sc = new Scanner(System.in);

        // inits
        int passwordLength;
        int howManyPasswords;
        int attempt;
        char[] validCharacters = { 'A', 'B', 'C', 'a', 'b', 'c', '0', '1', '2', '!' };
        ArrayList<Integer> attempts = new ArrayList<>();

        // user input
        System.out.println("Input password length");
        passwordLength = sc.nextInt();

        /// testxxxxxxxxxxxxxxxxxxxxxxxxxxxx

        // String Crack = "";

        // for (int i = 0; i < passwordLength; i++) {
        // char Random = validCharacters[0 + i];
        // Crack += Random;
        // }
        // System.out.println(Crack);

        // /test xxxxxxxxxxxxxxxxxxxxxxxxc

        System.out.println("How many passwords do you want to crack?");
        howManyPasswords = sc.nextInt();

        // password gen and crack loop
        for (int i = 0; i < howManyPasswords; i++) {

            // password gen
            String password = "";
            for (int j = 0; j < passwordLength; j++) {
                char random = validCharacters[r.nextInt(0, 10)];
                password += random;
            }

            // crack and attempt counter loop
            boolean found = false;
            attempt = 1;
            while (!found) {
                // crack gen
                String crack = "";
                for (int j = 0; j < passwordLength; j++) {
                    char random = validCharacters[r.nextInt(0, 10)];
                    crack += random;
                }
                // checker
                if (crack.equals(password)) {
                    System.out.println("Found: " + password + " == " + crack);
                    found = true;
                    attempts.add(attempt);
                } else {
                    attempt++;
                }
            }
        }

        // the statistics
        int max = attempts.get(0);
        int min = attempts.get(0);
        int sum = 0;

        for (int i = 0; i < attempts.size(); i++) {
            if (attempts.get(i) > max) {
                max = attempts.get(i);
            }
            if (attempts.get(i) < min) {
                min = attempts.get(i);
            }
            sum += attempts.get(i);
        }

        // print the results
        System.out.println("The worst case scenario is: " + max);
        System.err.println("The best case scenario is: " + min);
        System.out.println("The average is: " + sum / attempts.size());

        sc.close();
    }
}