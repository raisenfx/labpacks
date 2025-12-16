import java.io.*;
import java.util.Scanner;

public class ReplaceWordInFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter input file path: ");
        String inputFile = scanner.nextLine();

        System.out.print("Enter word to be replaced: ");
        String oldWord = scanner.nextLine();

        System.out.print("Enter replacement word: ");
        String newWord = scanner.nextLine();

        System.out.print("Enter output file path: ");
        String outputFile = scanner.nextLine();

        try (
                BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                PrintWriter writer = new PrintWriter(new FileWriter(outputFile))
        ) {
            String line;

            while ((line = reader.readLine()) != null) {
                line = line.replace(oldWord, newWord);
                writer.println(line);
            }

            System.out.println(
                    "Replaced '" + oldWord + "' with '" + newWord +
                            "' in " + inputFile + " → " + outputFile
            );

        } catch (IOException e) {
            System.out.println("File error occurred!");
        }
    }
}
