import java.util.Scanner;

public class BetrunkenV2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Wie alt bist du?");
        int age = sc.nextInt();

        System.out.println("Hast du deinen Führerschein dabei?");
        boolean license = sc.nextBoolean();

        System.out.println("Wie viel Bier hast du getrunken?");
        int beer = sc.nextInt();

        System.out.println("Wie viel Shots hast du getrunken?");
        int shots = sc.nextInt();
        
        int drinks = beer + shots;
        
        if (age >= 19 && license && drinks <= 2) {
            System.out.println("Du darfst Autofahren");
        }
        else if (age >= 17 && license && drinks < 1) {
            System.out.println("Du darfst Autofahren");
        }
        else {
            System.out.println("Du darfst nicht Autofahren");
        }
        sc.close();
    }
}