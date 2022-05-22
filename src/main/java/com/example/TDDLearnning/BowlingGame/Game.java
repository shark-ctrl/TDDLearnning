package com.example.TDDLearnning.BowlingGame;

public class Game {
    private int[] rolls = new int[21];
    private int currentRoll = 0;


    public void roll(int pins) {
        rolls[currentRoll++] = pins;
    }

    public int score() {
        int score = 0;
//        代表局索引 0则是第0局
        int frameIndex = 0;
        for (int frame = 0; frame < 10; frame++) {
            if (isSpare(frameIndex)) {
                //如果完成spare，分数则是10+下一局的分数
                score += 10 + rolls[frameIndex + 2];
                //越过这局的分数
                frameIndex += 2;
            } else {
                //成绩等于每局的两球成绩相加
                score += rolls[frameIndex] + rolls[frameIndex + 1];
                //越过这局的分数
                frameIndex += 2;
            }

        }

        return score;
    }

    private boolean isSpare(int frameIndex) {
        return rolls[frameIndex] + rolls[frameIndex + 1] == 10;
    }
}
