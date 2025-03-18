import java.util.Arrays;
import java.util.Random;

public class GaudiMitStatistikV2 {
    public static void main(String[] args) {

        int[] randomHundred = new int[100];
        for (int i = 0; i < randomHundred.length; i++) {
            Random r = new Random();
            randomHundred[i] = r.nextInt(1,100);
        }

        int c = 1;
        int temp = 0;
        int[] sortedHundred = new int[100];

        for (int i = 0; i < randomHundred.length; i++) {
            for (int j = 0; j < randomHundred.length; j++) {
                if (randomHundred[j] == c) {
                    sortedHundred[temp] = randomHundred[j];
                    temp++;
                }
            }
            c++;
        }
        System.out.println(Arrays.toString(sortedHundred));
    }
}
