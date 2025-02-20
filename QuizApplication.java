import java.util.*;

class Question {
    String question;
    String[] options;
    int correctOption;

    public Question(String question, String[] options, int correctOption) {
        this.question = question;
        this.options = options;
        this.correctOption = correctOption;
    }
}

public class QuizApplication {
    private static final int TIME_LIMIT = 10;
    private static List<Question> questions = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static int score = 0;

    public static void main(String[] args) {
        loadQuestions();
        startQuiz();
        displayResult();
    }

    private static void loadQuestions() {
        questions.add(new Question("What is the capital of France?",
                new String[]{"1. Berlin", "2. Madrid", "3. Paris", "4. Rome"}, 3));
        questions.add(new Question("Which programming language is used for Android development?",
                new String[]{"1. Python", "2. Java", "3. Swift", "4. C#"}, 2));
        questions.add(new Question("Who developed Java?",
                new String[]{"1. James Gosling", "2. Dennis Ritchie", "3. Bjarne Stroustrup", "4. Guido van Rossum"}, 1));
    }

    private static void startQuiz() {
        System.out.println("Welcome to the Quiz! You have " + TIME_LIMIT + " seconds per question.\n");

        for (Question q : questions) {
            System.out.println(q.question);
            for (String option : q.options) {
                System.out.println(option);
            }
            System.out.print("Enter your answer (1-4): ");

            long startTime = System.currentTimeMillis();
            int answer = getAnswerWithinTime();
            long endTime = System.currentTimeMillis();

            if (endTime - startTime > TIME_LIMIT * 1000) {
                System.out.println("Time is up! Moving to the next question.\n");
            } else if (answer == q.correctOption) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Wrong answer!\n");
            }
        }
    }

    private static int getAnswerWithinTime() {
        Timer timer = new Timer();
        final boolean[] answered = {false};
        final int[] userAnswer = {0};

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (!answered[0]) {
                    System.out.println("\nTime's up! Moving to the next question...");
                    answered[0] = true;
                }
            }
        }, TIME_LIMIT * 1000);

        if (scanner.hasNextInt()) {
            userAnswer[0] = scanner.nextInt();
            answered[0] = true;
        }

        timer.cancel();
        return userAnswer[0];
    }

    private static void displayResult() {
        System.out.println("\nQuiz Over! Your Score: " + score + "/" + questions.size());
    }
}