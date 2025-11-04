import java.util.Random;
import java.text.DecimalFormat;

public class Lab6S5Bonus {
    public static void main(String[] args) {
        final int STUDENTS = 5;
        final int QUIZZES = 4;
        int[][] scores = new int[STUDENTS][QUIZZES];

        Random rand = new Random();
        DecimalFormat df = new DecimalFormat("0.00");

        for (int i = 0; i < STUDENTS; i++) {
            for (int j = 0; j < QUIZZES; j++) {
                scores[i][j] = rand.nextInt(101); 
            }
        }

        System.out.println("Scores Table (Students x Quizzes):");
        for (int i = 0; i < STUDENTS; i++) {
            for (int j = 0; j < QUIZZES; j++) {
                System.out.printf("%4d", scores[i][j]);
            }
            System.out.println();
        }

        System.out.println();

        System.out.println("Student Averages:");
        for (int i = 0; i < STUDENTS; i++) {
            double sum = 0;
            for (int j = 0; j < QUIZZES; j++) {
                sum += scores[i][j];
            }
            double avg = sum / QUIZZES;
            System.out.println("Student " + i + ": " + df.format(avg));
        }

        System.out.println();

        System.out.println("Quiz Averages:");
        for (int j = 0; j < QUIZZES; j++) {
            double sum = 0;
            for (int i = 0; i < STUDENTS; i++) {
                sum += scores[i][j];
            }
            double avg = sum / STUDENTS;
            System.out.println("Quiz " + j + ": " + df.format(avg));
        }

        System.out.println();

        int highest = -1;
        int highestStudent = -1;
        int highestQuiz = -1;

        for (int i = 0; i < STUDENTS; i++) {
            for (int j = 0; j < QUIZZES; j++) {
                if (scores[i][j] > highest ||
                    (scores[i][j] == highest && i < highestStudent) ||
                    (scores[i][j] == highest && i == highestStudent && j < highestQuiz)) {
                    highest = scores[i][j];
                    highestStudent = i;
                    highestQuiz = j;
                }
            }
        }

        System.out.println("Highest Score: " + highest +
                " at (studentIndex=" + highestStudent +
                ", quizIndex=" + highestQuiz + ")");
    }
}
