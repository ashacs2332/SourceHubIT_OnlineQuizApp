package learn;

import java.util.*;

class Question {
    String question;
    String[] options;
    int correctAnswer;  

    
    public Question(String question, String[] options, int correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }


    public void displayQuestion() {
        System.out.println(question);
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
    }

    
    public boolean checkAnswer(int answer) {
        return answer == correctAnswer;
    }
}

class Quiz {
    String topic;
    ArrayList<Question> questions;

    public Quiz(String topic) {
        this.topic = topic;
        questions = new ArrayList<>();
    }

  
    public void addQuestion(Question q) {
        questions.add(q);
    }

 
    public void startQuiz(String userName) {
        Scanner sc = new Scanner(System.in);
        int score = 0;

        System.out.println("\nHi " + userName + "! Welcome to the " + topic + " Quiz \n");

        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            System.out.println("Q" + (i + 1) + ":");
            q.displayQuestion();
            System.out.print("Your Answer: ");
            int ans = sc.nextInt();

            if (q.checkAnswer(ans)) {
                System.out.println(" Correct!\n");
                score++;
            } else {
                System.out.println(" Wrong! Correct Answer: " + q.options[q.correctAnswer - 1] + "\n");
            }
        }

        System.out.println("Quiz Finished!");
        System.out.println(userName + ", Your Score: " + score + "/" + questions.size());
    }
}

public class OnlineQuizApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

       
        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        
        System.out.println("\nSelect a Quiz Topic:");
        System.out.println("1. Java Basics");
        System.out.println("2. General Knowledge");
        int choice = sc.nextInt();

        Quiz quiz;
        if (choice == 1) {
            quiz = new Quiz("Java Basics");
            quiz.addQuestion(new Question("Which keyword is used to define a class in Java?",
                    new String[]{"class", "define", "struct", "function"}, 1));
            quiz.addQuestion(new Question("Which data type is used to store text?",
                    new String[]{"int", "String", "char", "float"}, 2));
            quiz.addQuestion(new Question("Which symbol is used for single-line comments?",
                    new String[]{"//", "/*", "#", "--"}, 1));
        } else {
            quiz = new Quiz("General Knowledge");
            quiz.addQuestion(new Question("What is the capital of India?",
                    new String[]{"New Delhi", "Mumbai", "Kolkata", "Chennai"}, 1));
            quiz.addQuestion(new Question("Which is the largest planet in our solar system?",
                    new String[]{"Earth", "Mars", "Jupiter", "Saturn"}, 3));
            quiz.addQuestion(new Question("Who is known as the Father of Computers?",
                    new String[]{"Charles Babbage", "Alan Turing", "Bill Gates", "Steve Jobs"}, 1));
        }

        
        quiz.startQuiz(name);
    }
}

