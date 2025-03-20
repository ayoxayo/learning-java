import java.util.ArrayList;
import java.util.Random;

public class CyberSecurityV1 {
    public static void main(String[] args) {
        Random r = new Random();

        // inits
        int passwordLength = 4;
        int howManyPasswords = 1000;
        int attempt;
        char[] validCharacters = { 'A', 'B', 'C', 'a', 'b', 'c', '0', '1', '2', '!' };
        ArrayList<Integer> attempts = new ArrayList<>();

        // password gen and crack loop
        for (int h = 0; h < howManyPasswords; h++) {

            // password gen
            String password = "";
            for (int j = 0; j < passwordLength; j++) {
                char random = validCharacters[r.nextInt(0, 10)];
                password += random;
            }

            // crack and attempt counter loop
            boolean found = false;
            attempt = 1;
            String crack = "";

            // crack gen
            for (int i = 0; i < validCharacters.length && !found; i++) {
                char char1 = validCharacters[i];
                for (int j = 0; j < validCharacters.length && !found; j++) {
                    char char2 = validCharacters[j];
                    for (int j2 = 0; j2 < validCharacters.length && !found; j2++) {
                        char char3 = validCharacters[j2];
                        for (int k = 0; k < validCharacters.length && !found; k++) {
                            char char4 = validCharacters[k];
                            crack += char1;
                            crack += char2;
                            crack += char3;
                            crack += char4;

                            // check length
                            if (crack.length() == 4) {
                                // System.out.println(crack + "\n"); // testing
                                // check if match password
                                if (crack.equals(password)) {
                                    System.out.println("Found: " + password + " == " + crack);
                                    found = true;
                                    attempts.add(attempt);
                                } else {
                                    attempt++;
                                    crack = "";
                                }
                            }
                        }
                    }
                }
            }
        }

        // the statistics
        int max = attempts.get(0);
        int min = attempts.get(0);
        int sum = 0;
        // sorting
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
    }
}