package com.example.quiztruefalseapp.model;

public class QuizQuestion {
    private String questionText;
    private boolean trueAnswer;

    public QuizQuestion(String questionText, boolean answer) {
        this.questionText = questionText;
        this.trueAnswer = answer;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public boolean isTrueAnswer() {
        return trueAnswer;
    }

    public void setTrueAnswer(boolean answer) {
        this.trueAnswer = answer;
    }
}
