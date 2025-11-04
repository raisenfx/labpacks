import java.util.Arrays;
import java.util.Random;

public class Lab6S2 {
    public static void main(String[] args) {
        Random rand = new Random();

        int size = rand.nextInt(11) + 10; // 10–20
        int[] numbers = new int[size];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(100);
        }

        System.out.println("Original array:");
        System.out.println(Arrays.toString(numbers));

        int[] rotated = rotateRight(numbers);

        System.out.println("\nRotated array:");
        System.out.println(Arrays.toString(rotated));
    }


    public static int[] rotateRight(int[] arr) {
        if (arr.length == 0) return arr;

        int last = arr[arr.length - 1];
        for (int i = arr.length - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = last;

        return arr;
    }
}

