import java.util.Random;
import java.util.Scanner;

public class MineSweeperV1 {
    public static void main(String[] args) {
        // importing functions
        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        // setting map and initializing variables
        int[][] map = new int[10][10];
        int mineCount = 0;
        boolean dead = false;
        int clearedFields = 0;
        double safeFields = 0;
        double clearPercentage = 0;
        boolean gameover = false;
        // generating mine fields and counting them
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                map[i][j] = r.nextInt(4) - 3;
                if (map[i][j] == 0) {
                    mineCount++;
                }
            }
        }
        // game loop
        while (!gameover) {
            // stats maths
            safeFields = map.length * 10 - mineCount;
            clearPercentage = clearedFields / safeFields * 100;
            // printer
            System.out.printf("%s \n", "   A  B  C  D  E  F  G  H  I  J");
            for (int i = 0; i < map.length; i++) {
                System.out.print(i + " ");
                for (int j = 0; j < map.length; j++) {
                    if (map[i][j] == 42) {
                        System.out.printf("[*]", map[i][j]);
                    }
                    if (map[i][j] == 45) {
                        System.out.printf("[-]", map[i][j]);
                    }
                    if (map[i][j] <= 0) {
                        System.out.printf("[ ]", map[i][j]);
                    }
                }
                System.out.println();
            }
            System.out.printf("%s %d %s %.0f (%.2f%s) %s \n%s %d %s \n", "You have cleared", clearedFields, "/",
                    safeFields, clearPercentage, "%",
                    "of the field of its mines.", "There are", mineCount, "mines left.");
            // stats print
            if (clearPercentage == 100) {
                System.out.println("...wow, you win. Congrats..");
                gameover = true;
            } else if (dead) {
                System.out.println("That... was a mine. You died.");
                gameover = true;
            } else {
                // user input + validator
                String userPosition = "";
                int col;
                int row;
                do {
                    System.out.println("Where do you want to search for mines?");
                    userPosition = sc.nextLine();
                    row = userPosition.charAt(1) - '0';
                    col = userPosition.charAt(0) - 'A';
                } while (col > 9 || col < 0 || row > 9 || userPosition.length() != 2 || map[row][col] == 45);
                // win / lose conditions and actions
                if (map[row][col] == 0) {
                    dead = true;
                    map[row][col] = 42;
                } else {
                    map[row][col] = 45;
                    clearedFields++;
                }
            }
        }
        sc.close();
    }
}