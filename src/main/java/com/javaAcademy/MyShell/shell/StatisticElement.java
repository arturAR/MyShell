package com.javaAcademy.MyShell.shell;

public class StatisticElement {

    private int correct;
    private int notCorrect;

    public StatisticElement() {
        this.correct = 0;
        this.notCorrect = 0;
    }

    public int getCorrect() {
        return correct;
    }

    public void incrementCorrect() {
        correct++;
    }

    public int getNotCorrect() {
        return notCorrect;
    }

    public void incrementNotCorrect() {
        notCorrect++;
    }

}
