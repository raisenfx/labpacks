import java.util.Arrays;

public class Lab6S1 {
    public static void main(String[] args) {
        
        int[] oldRoster = new int[20];
        for (int i = 0; i < oldRoster.length; i++) {
            oldRoster[i] = 1000 + i; 
        }

        int newSize = 42;

        int[] newRoster = expandRoster(oldRoster, newSize);

        
        System.out.println("Old roster (" + oldRoster.length + " students):");
        System.out.println(Arrays.toString(oldRoster));

        System.out.println("\nNew roster (" + newRoster.length + " students):");
        System.out.println(Arrays.toString(newRoster));
    }

  
    public static int[] expandRoster(int[] oldRoster, int newSize) {
        int[] newRoster = new int[newSize];

        
        for (int i = 0; i < oldRoster.length; i++) {
            newRoster[i] = oldRoster[i];
        }

       
        return newRoster;
    }
}
