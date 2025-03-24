import java.util.ArrayList;
import java.util.Scanner;

public class RPGV1 {
    public static void main(String[] args) {
        // initializing scanner
        Scanner sc = new Scanner(System.in);
        // initializing the variables
        String lines = "----------------------------";
        String[][] choices = {
                // {parentID, ID, choiceTxt, resultTxt, moveToID }
                { "-1", "0", "", "You are standing in a bar" },

                { "0", "1", "Go to the forest", "You made it to the forest." },
                { "0", "2", "Have a drink", "You enjoy sipping your beverage", "0" },

                { "1", "3", "Fight the monster", "The monster is a tough enemy, but you defeated it.", "1" },
                { "1", "4", "Flee the monster", "You ran to the back to the bar like a coward.", "0" },
        };
        int currentChoice = 0;
        int parentID = 0;
        int id = 0;
        ArrayList<Integer> viableChoices = new ArrayList<>(); // added <Integer> for happy IDE
        boolean gameover = false;
        // gameplay loop
        while (!gameover) {
            // printer + adding IDs for the validator
            System.out.printf("%s\n%s\n", choices[currentChoice][3], lines);
            for (int i = 0; i < choices.length; i++) {
                parentID = Integer.parseInt(choices[i][0]);
                id = Integer.parseInt(choices[i][1]);
                if (parentID == currentChoice) {
                    System.out.println(id + ") " + choices[i][2]);
                    viableChoices.add(id);
                }
            }
            System.out.println(lines);
            // user input and validator
            do {
                System.out.println("What do you want to do next?");
                currentChoice = sc.nextInt();
            } while (!viableChoices.contains(currentChoice));
            viableChoices.clear();
            // "jumps"
            if (choices[currentChoice].length == 5) {
                System.out.printf("%s\n%s\n", choices[currentChoice][3], lines);
                currentChoice = Integer.parseInt(choices[currentChoice][4]);
            }
        }
        sc.close(); // for happy IDE
    }
}