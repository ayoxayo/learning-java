import java.util.Scanner;

public class TaschenrechnerV2 {
public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    
    System.out.println("Gib die erste Zahl ein:");
    int a = sc.nextInt();
    System.out.println("Gib die zweite Zahl ein");
    int b = sc.nextInt();

    System.out.println("Gib den Operator (+, -, *, /, %) ein:");
    char Operator = sc.next().charAt(0);

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
   
        default:
            System.out.println("Falscher Operator");
    }
    sc.close();
 }
}
