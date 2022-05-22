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
        for (int i = 0; i < rolls.length; i++) {
            /**
             * 错误代码，假如第一局分数为1 5，第2局为5 ,5 这段代码会使得第一局第2球分数+第2局第一球分数相加触发spare
             * if (rolls[i] + rolls[i+1] == 10) // spare
             *                 score += ...
             */


            score += rolls[i];
        }
        return score;
    }
}
