import java.util.Random;

public class Lab6S3 {
    public static void main(String[] args) {
        final int DAYS = 1_000_000; 
        String[] weatherArray = new String[10]; 

        
        for (int i = 0; i < 4; i++) weatherArray[i] = "Sunny";
        for (int i = 4; i < 7; i++) weatherArray[i] = "Cloudy";
        for (int i = 7; i < 9; i++) weatherArray[i] = "Rainy";
        weatherArray[9] = "Stormy";

       
        int sunnyCount = 0, cloudyCount = 0, rainyCount = 0, stormyCount = 0;

        Random rand = new Random();

       
        for (int i = 0; i < DAYS; i++) {
            String today = weatherArray[rand.nextInt(weatherArray.length)];

            switch (today) {
                case "Sunny" -> sunnyCount++;
                case "Cloudy" -> cloudyCount++;
                case "Rainy" -> rainyCount++;
                case "Stormy" -> stormyCount++;
            }
        }

        // Results
        System.out.println("Weather Simulation Results (" + DAYS + " days):");
        System.out.printf("Sunny : %d (%.2f%%)%n", sunnyCount, (sunnyCount * 100.0 / DAYS));
        System.out.printf("Cloudy: %d (%.2f%%)%n", cloudyCount, (cloudyCount * 100.0 / DAYS));
        System.out.printf("Rainy : %d (%.2f%%)%n", rainyCount, (rainyCount * 100.0 / DAYS));
        System.out.printf("Stormy: %d (%.2f%%)%n", stormyCount, (stormyCount * 100.0 / DAYS));
    }
}
