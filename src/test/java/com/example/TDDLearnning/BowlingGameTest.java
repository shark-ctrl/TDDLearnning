package com.example.TDDLearnning;

import com.example.TDDLearnning.BowlingGame.Game;
import junit.framework.TestCase;

public class BowlingGameTest extends TestCase {

    /**
     * 第一个测试用例 全部投0分 返回0分
     *
     * @throws Exception
     */
    public void testGutterGame() throws Exception {
        Game g = new Game();
        int n = 20;
        int pins = 0;
        for (int i = 0; i < n; i++) {
            g.roll(pins);
        }

        assertEquals(0, g.score());
    }

    /**
     * 第2个测试用例，全部1分，得到所有分数相加
     *
     * @throws Exception
     */
    public void testAllOnes() throws Exception {
        Game g = new Game();
        for (int i = 0; i < 20; i++) {
            g.roll(1);
        }
        assertEquals(20, g.score());
    }
}
