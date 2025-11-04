import java.util.Scanner;

public class Lab5S2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Tabanı giriniz: ");
        long base = input.nextLong();

        System.out.print("Üssü giriniz: ");
        int exp = input.nextInt();

        long result = power(base, exp);
        System.out.println(base + "^" + exp + " = " + result);

        input.close();
    }

    public static long power(long base, int exp) {
        if (exp == 0) {
            return 1;
        } else {
            return base * power(base, exp - 1);
        }
    }
}

