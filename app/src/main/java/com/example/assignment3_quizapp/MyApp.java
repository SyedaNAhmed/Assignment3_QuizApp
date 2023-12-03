package com.example.assignment3_quizapp;

import android.app.Application;

import java.util.Arrays;
import java.util.List;

public class MyApp extends Application {
    private List<String> questions;
    private int currentQuestionIndex;

    @Override
    public void onCreate() {
        super.onCreate();

        // Initialize your data
        questions = Arrays.asList(
                "Question 1: Toronto is the capital city of Ontario?",
                "Question 2: Montreal is the capital city of Quebec?",
                "Question 3: NewYork city is the capital city of New York?"
        );

        currentQuestionIndex = 0;
    }

    public List<String> getQuestions() {
        return questions;
    }

    public int getCurrentQuestionIndex() {
        return currentQuestionIndex;
    }

    public void moveToNextQuestion() {
        if (currentQuestionIndex < questions.size() - 1) {
            currentQuestionIndex++;
        }
    }

    public boolean isQuizCompleted() {
        return currentQuestionIndex >= questions.size();
    }

    // New method to get the current question
    public String getCurrentQuestion() {
        if (!isQuizCompleted()) {
            return questions.get(currentQuestionIndex);
        } else {
            return "End of questions";
        }
    }
}
