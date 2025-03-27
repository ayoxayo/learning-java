import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class RPGV2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        String lines = "----------------------------";
        String[][] choices = {
                // {parentID, ID, choiceTxt, resultTxt, moveToID }

                { "-1", "0", "", "You are standing in a bar." },

                { "0", "1", "Go into the wilderness in search of an adventure",
                        "You have arrived in the wilderness. You encounter a monster" },
                { "0", "2", "Have a drink and rest", "You enjoy your drink", "0" },
                { "0", "3", "Impress the princess with your treasures", "You give it your all!", "0" },

                { "1", "4", "Fight the monster", "", "6" },
                { "1", "5", "Flee the monster", "You run back to the bar like a coward!", "0" },

                { "4", "6", "", "" },

                { "6", "7", "Try to harm the monster with your sword", "You throw yourself into battle!",
                        "6" },
                { "6", "8", "It's time to go", "You attempt to flee, but the monster is chasing you", "0" },

                { "-1", "9", "",
                        "Unfortunately, you time is up. Death is already waiting for you with a friendly grin" }, // dead
                { "-1", "10", "", "You're the greatest hero of all time! Hooray!" }, // won

        }; // choice vars
        int currentChoice = 0;
        int parentID = 0;
        int id = 0;
        ArrayList<Integer> viableChoices = new ArrayList<>(); // added <Integer> for happy IDE
        // combat vars
        boolean gameover = false;
        int lifeMax = 10;
        int pLife = lifeMax;
        int mLife = -1;
        int pAttack = -1;
        int mAttack = -1;
        int mGold = -1;
        int pGold = 0;
        int pDamage = -1;
        int mDamage = -1;
        // gameplay loop
        while (!gameover) {
            // "auto jumps"
            if (choices[currentChoice].length == 5) {
                System.out.printf("%s\n%s\n", choices[currentChoice][3], lines);
                currentChoice = Integer.parseInt(choices[currentChoice][4]);
            }
            // printer + validator
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
            if (currentChoice != 9) {
                do {
                    System.out.println("What do you want to do next?");
                    currentChoice = sc.nextInt();
                } while (!viableChoices.contains(currentChoice));
                viableChoices.clear();
            }
            // game mechanics and scenarios
            if (currentChoice == 2) {
                if (pGold > 100) {
                    pGold -= 100;
                    for (int j = 0; j < lifeMax || j < 3; j++) {
                        pLife++;
                    }
                } else {
                    System.out.println("You're too poor!\nGo slay a monster or something..");
                    currentChoice = 0;
                }
            } else if (currentChoice == 3) {
                if (pGold >= 1000 && lifeMax >= 15) {
                    System.out.println(
                            "The princess instantly falls in love with your treasures and mar1ries you on the spot.");
                    currentChoice = 10;
                } else {
                    int missingGold = Math.abs(pGold - 1000);
                    int missingExp = Math.abs(lifeMax - 15);
                    System.out.printf("%s\n%s %d %s\n%s %d %s\n",
                            "Hahahah, you're such an inexperienced and broke wuss. Go slay a monster boy.",
                            "You still need at least", missingGold, "Gold.", "And", missingExp,
                            "more years of experience.");
                    currentChoice = 0;
                }
            } else if (currentChoice == 4) {
                mLife = r.nextInt(3, 21);
                pAttack = r.nextInt(1, pLife);
                mAttack = r.nextInt(1, mLife);
                mGold = r.nextInt(1, mLife) * 100;
                currentChoice = 6;
            }
            if (currentChoice == 6) {
                System.out.printf("%s %d %s %d %s", "The monster has", mLife, "HP, and you have", pLife, "HP.");
            } else if (currentChoice == 7) {
                pDamage = r.nextInt(0, pAttack);
                mDamage = r.nextInt(0, mAttack);
                mLife -= pDamage;
                if (mLife > 0) {
                    pLife -= mDamage;
                }
                if (pLife > 0) {
                    if (mLife > 0) {
                        System.out.printf("%s %d %s %d %s\n", "You hit the monster with", pDamage,
                                "Damage. It still has",
                                mLife, "HP left.");
                        System.out.printf("%s %d %s %d %s", "The monster hit you with", mDamage,
                                "Damage. You still have",
                                pLife, "HP left.");
                        currentChoice = 6;
                    } else {
                        pGold += mGold;
                        lifeMax++;
                        System.out.printf("%s %d %s\n", "You have slayed the monster!\nYou find", mGold,
                                "next to it's corpse. Naturally, you take it.\nYour experience has increased, so has your max HP");
                        currentChoice = 1;
                    }
                } else {
                    currentChoice = 9;
                }
            } else if (currentChoice == 8) {
                mDamage = r.nextInt(0, mAttack);
                pLife -= mDamage;
                System.out.printf("%s %d %s\n",
                        "The monster managed to hit you whilst you were running away.\nYou took", mDamage,
                        "damage.");
            } else if (currentChoice == 9) {
                gameover = true;
            }
        }
        System.out.println("Thank you for playing!");
        sc.close();
    }
}
