import java.util.Scanner;

public class Lab5S1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Bir sayı giriniz: ");
        int n = input.nextInt();
        
        n = Math.abs(n);
        
        int result = sumDigits(n);
        System.out.println("Basamakların toplamı: " + result);
        
        input.close();
    }

    public static int sumDigits(int n) {
        if (n < 10) {
            return n; 
        } else {
            return (n % 10) + sumDigits(n / 10); 
        }
    }
}
