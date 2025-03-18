import java.util.Scanner;

public class TaschenrechnerV3 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        char Operator = 'x';
        int a;
        int b;

        while ( Operator != 'X' ) {
            System.out.println("Gib den Operator (+, -, *, /, %) ein:");
            Operator = sc.next().charAt(0);

            if (Operator == '+' || Operator == '-' || Operator == '*' || Operator == '/' || Operator == '%') {
                System.out.println("Gib die erste Zahl ein:");
                    a = sc.nextInt();
                System.out.println("Gib die zweite Zahl ein");
                    b = sc.nextInt();

                // calculations
                switch (Operator) {
                    case '+':
                        System.out.println("" + a + Operator + b + "=" + (a + b));
                        break;
                    case '-':
                        System.out.println("" + a + Operator + b + "=" + (a - b));
                    break;
                    case '*':
                        System.out.println("" + a + Operator + b + "=" + (a * b));
                    break;
                    case '/':
                        System.out.println("" + a + Operator + b + "=" + (a / b));
                    break;
                    case '%':
                        System.out.println("" + a + Operator + b + "=" + (a % b));
                    break;
                    case 'X':
                        break;
                    default:
                        System.out.println("Falscher Operator");
                }
            }
        }
        sc.close();
    }
}
