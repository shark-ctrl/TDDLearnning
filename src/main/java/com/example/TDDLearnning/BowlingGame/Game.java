package com.example.TDDLearnning.BowlingGame;

public class Game {
    //    private int score = 0;
    private int[] rolls = new int[21];
    private int currentRoll = 0;


    public void roll(int pins) {
        rolls[currentRoll++] = pins;
    }

    public int score() {
        int score = 0;
        int i = 0;
        for (int frame = 0; frame < 10; frame++) {
            //成绩等于每局的两球成绩相加
            score += rolls[i] + rolls[i + 1];
            //越过这局的分数
            i += 2;
        }

        return score;
    }
}
