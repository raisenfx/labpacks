import java.util.Arrays;
import java.util.Random;

public class Lab6S4 {
    public static void main(String[] args) {
        Random rand = new Random();

        
        int[] arr = new int[30];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(100) + 1;
        }

       
        System.out.println("Generated array:");
        System.out.println(Arrays.toString(arr));

        int peakCount = 0;
        int tallestPeak = Integer.MIN_VALUE;

        System.out.println("\nPeaks found at indices and values:");
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                System.out.println("Index " + i + " → Value " + arr[i]);
                peakCount++;
                if (arr[i] > tallestPeak) {
                    tallestPeak = arr[i];
                }
            }
        }

        System.out.println("\nTotal number of peaks: " + peakCount);
        if (peakCount > 0) {
            System.out.println("Tallest peak value: " + tallestPeak);
        } else {
            System.out.println("No peaks found.");
        }
    }
}
