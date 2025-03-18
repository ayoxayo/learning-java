import java.util.Arrays;
import java.util.Random;

public class GaudiMitStatistikV2_1 {
    public static void main(String[] args) {
        
        int[] randomHundred = new int[100];
        for (int i = 0; i < randomHundred.length; i++) {
            Random r = new Random();
            randomHundred[i] = r.nextInt(1,100);
        }
        for (int i = 0; i < randomHundred.length - 1; i++) {
            for (int j = 0; j < randomHundred.length - 1 - i; j++) {
                if (randomHundred[j] > randomHundred[j + 1]) {
                    int temp = randomHundred[j];
                    randomHundred[j] = randomHundred[j + 1];
                    randomHundred[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(randomHundred));
    }
}