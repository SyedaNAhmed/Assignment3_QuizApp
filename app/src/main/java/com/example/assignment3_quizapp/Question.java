package com.example.assignment3_quizapp;

public class Question {
    private String questionText;
    private int backgroundColor;

    public Question(String questionText, int backgroundColor) {
        this.questionText = questionText;
        this.backgroundColor = backgroundColor;
    }

    public String getQuestionText() {
        return questionText;
    }

    public int getBackgroundColor() {
        return backgroundColor;
    }
}
