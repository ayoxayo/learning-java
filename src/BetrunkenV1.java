import java.util.Scanner;

public class BetrunkenV1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Wie viel Bier hast du getrunken?");
        int beer = sc.nextInt();

        System.out.println("Wie viel Shots hast du getrunken?");
        int shots = sc.nextInt();

        int drinks = beer + shots;

        if (drinks == 0) {
            System.out.println("Du bist gar nicht betrunken");
        }
        else if (drinks <= 2 ) {
           System.out.println("Du bist leicht betrunken");
        }
        else if (beer <= 6 && shots == 0) {
              System.out.println("Du bist betrunken");
        }
        else {
            System.out.println("Du bist hoffnungslos betrunken");
        }
        sc.close();
    }
}
