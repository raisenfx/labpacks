import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class Wordstats {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter file path: ");
        String filePath = scanner.nextLine();

        HashMap<String, Integer> wordCount = new HashMap<>();
        int totalWords = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {

                String[] words = line.replaceAll("[^a-zA-Z ]", "")
                        .split("\\s+");

                for (String word : words) {
                    if (!word.isEmpty()) {
                        totalWords++;
                        word = word.toLowerCase();
                        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                    }
                }
            }

            PrintWriter writer = new PrintWriter("word_stats.txt");

            System.out.println("Total Words: " + totalWords);
            System.out.println("Unique Words: " + wordCount.size());

            writer.println("Total Words: " + totalWords);
            writer.println("Unique Words: " + wordCount.size());

            for (String key : wordCount.keySet()) {
                System.out.println(key + ": " + wordCount.get(key));
                writer.println(key + ": " + wordCount.get(key));
            }

            writer.close();
            System.out.println("Results written to word_stats.txt");

        } catch (IOException e) {
            System.out.println("Error reading file!");
        }
    }
}
