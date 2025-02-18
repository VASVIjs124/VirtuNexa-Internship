import java.util.Random;
import java.util.Scanner;

public class Task_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int score = 0;
        int totalQuestions = 5;

        for (int i = 0; i < totalQuestions; i++) {
            int num1 = random.nextInt(100);
            int num2 = random.nextInt(100);
            char operator = getRandomOperator(random);
            int correctAnswer = calculateAnswer(num1, num2, operator);

            System.out.printf("Question %d: %d %c %d = ?\n", i + 1, num1, operator, num2);
            int userAnswer = scanner.nextInt();

            if (userAnswer == correctAnswer) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong! The correct answer is " + correctAnswer);
            }
        }

        System.out.println("Quiz finished! Your score: " + score + "/" + totalQuestions);
        scanner.close();
    }

    private static char getRandomOperator(Random random) {
        char[] operators = {'+', '-', '*'};
        return operators[random.nextInt(operators.length)];
    }

    private static int calculateAnswer(int num1, int num2, char operator) {
        switch (operator) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
}
