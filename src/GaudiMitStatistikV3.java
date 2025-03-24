import java.util.Arrays;
import java.util.Random;

public class GaudiMitStatistikV3 {
    public static void main(String[] args) {
        Random r = new Random();
        int arrayLength = r.nextInt(50, 100);
        double sum = 0; // for the mean
        // populating the integer array
        int[] randomNumbers = new int[arrayLength];
        for (int i = 0; i < randomNumbers.length; i++) {
            randomNumbers[i] = r.nextInt(1, 100);
            sum += randomNumbers[i]; // for the mean
        }
        // sorted array with sorter
        int[] sortedNumbers = Arrays.copyOf(randomNumbers, arrayLength);
        // bubble sort
        for (int i = 0; i < sortedNumbers.length - 1; i++) {
            for (int j = 0; j < sortedNumbers.length - 1 - i; j++) {
                if (sortedNumbers[j] > sortedNumbers[j + 1]) {
                    int temp = sortedNumbers[j];
                    sortedNumbers[j] = sortedNumbers[j + 1];
                    sortedNumbers[j + 1] = temp;
                }
            }
        }
        // maths
        double median = 0;
        int mode = 0;
        double mean = sum / randomNumbers.length;
        int range = Math.abs(sortedNumbers[sortedNumbers.length - 1] - sortedNumbers[0]);
        // median
        if (sortedNumbers.length % 2 == 0) {
            median = (double) (sortedNumbers[sortedNumbers.length / 2] + sortedNumbers[sortedNumbers.length / 2 - 1])
                    / 2;
        } else {
            median = sortedNumbers[sortedNumbers.length / 2];
        }
        // mode
        int count = 0;
        int maxCount = 0;
        for (int i = 0; i < sortedNumbers.length - 1; i++) {
            if (sortedNumbers[i] == sortedNumbers[i + 1]) {
                count++;
            } else {
                if (count > maxCount) {
                    maxCount = count;
                    mode = sortedNumbers[i];
                }
                count = 1;
            }
        }
        // MAD
        int madSum = 0;
        for (int i = 0; i < sortedNumbers.length; i++) {
            double tempMean = Math.abs(sortedNumbers[i] - mean);
            madSum += tempMean;
        }
        double mad = (double) madSum / sortedNumbers.length;
        // /maths
        // printer
        System.out.println("Original dataset:");
        for (int i = 0; i < randomNumbers.length; i++) {
            int n = randomNumbers[i];
            System.out.print("[" + n + "]");
        }
        System.out.println();
        // printer sorted
        System.out.println("Sorted dataset:");
        for (int i = 0; i < sortedNumbers.length; i++) {
            int n = sortedNumbers[i];
            System.out.print("[" + n + "]");
        }
        System.out.println();
        System.out.printf(
                "The arithmetic mean is: %.2f\nThe range is: %d\nThe median is: %.2f\nThe mode is: %d with %d\nThe mean absolute deviation is: %.2f\n",
                mean, range, median, mode, maxCount, mad);
    }
}
