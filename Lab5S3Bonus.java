import java.util.Scanner;

public class Lab5S3Bonus {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Bir sayı giriniz (n): ");
        int n = input.nextInt();

        int result = fib(n);
        System.out.println("fib(" + n + ") = " + result);

        input.close();
    }

    public static int fib(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }
}

