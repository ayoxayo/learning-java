public class CleanThisV1 {
    public static void main (String[] args) {
        int age = 14;
        boolean withAdult = true;
        boolean vip = false;
        boolean access = false;
        //
        if (age >= 18) {
            System.out.println("Grünes Band");
            access = true;
        }
        else if (age >= 16) {
            System.out.println("Gelbes Band");
            access = true;
        }
        else if (age >= 4 && withAdult) {
            System.out.println("Rotes Band");
            access = true;
        }
        else {
            System.out.println("Kein Zutritt");
            access = false;
        }
        //
        if (vip && access)
        System.out.println("Goldenes Band dazu!");
        else {System.out.println("Kein goldenes Band dazu!");}
    }
}
//      old code with the "compact challage"
        // int age = 14;
        // boolean withAdult = true;
        // boolean VIP = false;
        // //
        // if (age < 4) System.out.println("Kein Zutritt");
        // else if (age < 16 && withAdult) { System.out.println("Rotes Band"); }
        // else if ( age >= 16 && age < 18 ) { System.out.println("Gelbes Band"); }
        // else if (age >= 18) { System.out.println("Grünes Band"); }
        // else { System.out.println("Kein Zutritt"); }
        // //
        // if (VIP && age > 4 && (age >= 16 || withAdult)) { System.out.println("Goldenes Band dazu!");
        // } else { System.out.println("Kein goldenes Band dazu!");}
        //
        // cleaner code re-version
        //