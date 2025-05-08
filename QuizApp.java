import java.util.Scanner;

public class QuizApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] questions = {
            "1. What is the capital of France?",
            "2. Which language runs in a web browser?",
            "3. Who developed Java?",
            "4. What is the extension of Java files?",
            "5. Which one is not an OOP concept in Java?"
        };

        String[][] options = {
            {"a) Berlin", "b) Madrid", "c) Paris", "d) Rome"},
            {"a) Java", "b) C", "c) Python", "d) JavaScript"},
            {"a) Apple", "b) Microsoft", "c) Sun Microsystems", "d) Google"},
            {"a) .class", "b) .java", "c) .js", "d) .py"},
            {"a) Encapsulation", "b) Inheritance", "c) Compilation", "d) Abstraction"}
        };

        char[] answers = {'c', 'd', 'c', 'b', 'c'};

        int score = 0;

        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);
            for (String option : options[i]) {
                System.out.println(option);
            }

            System.out.print("Your answer: ");
            char userAnswer = sc.next().toLowerCase().charAt(0);

            if (userAnswer == answers[i]) {
                score++;
                System.out.println("Correct!\n");
            } else {
                System.out.println("Wrong! Correct answer: " + answers[i] + "\n");
            }
        }

        System.out.println("Quiz finished!");
        System.out.println("Your score: " + score + " out of " + questions.length);

        sc.close();
    }
}
