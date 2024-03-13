package com.crio.xquiz;

import java.util.*;

public class Quiz {
    private String quizName;
    private List<Question> questions;
    private int finalScore;

    public Quiz(String quizName) {
        if (quizName == null || quizName.isEmpty()) {
            System.out.println("Quiz Name cannot be null or empty!");
        } else {
            this.quizName = quizName;
            this.questions = new ArrayList<>();
            this.finalScore = 0;
        }
    }

    public String getQuizName() {
        return quizName;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public int getFinalScore() {
        return finalScore;
    }

    public void addQuestion(Question question) {
        if (question == null) {
            System.out.println("Question cannot be null!");
        } else {
            questions.add(question);
        }
    }

    public void attemptQuiz() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < questions.size(); ++i) {
            questions.get(i).display();
            int opt = sc.nextInt();
            if (opt < 1 || opt > questions.get(i).getChoices().size()) {
                System.out.println("Please choose a number between 1 and " + questions.get(i).getChoices().size());
                i--;
            } else if (questions.get(i).checkAnswer(questions.get(i).getChoices().get(opt - 1))) {
                finalScore++;
            }
        }
        sc.close();
    }

    public void revealAnswerKey() {
        for (int i = 0; i < questions.size(); i++) {
            System.out.println("Question no. " + (i + 1) + " : " + questions.get(i).getQuestionText() +
                    "\nAnswer no. " + (i + 1) + " : " + questions.get(i).getAnswer());
        }
    }
}
