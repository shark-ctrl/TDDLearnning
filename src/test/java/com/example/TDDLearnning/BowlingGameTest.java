package com.example.TDDLearnning;

import com.example.TDDLearnning.BowlingGame.Game;
import junit.framework.TestCase;

public class BowlingGameTest extends TestCase {

    private Game g;

    /**
     * 跑每个测试单元前，都会执行的方法
     * @throws Exception
     */
    @Override
    protected void setUp() throws Exception {
        g = new Game();
    }

    /**
     * 第一个测试用例 全部投0分 返回0分
     *
     * @throws Exception
     */
    public void testGutterGame() throws Exception {
        rollMany(20, 0);
        assertEquals(0, g.score());
    }

    private void rollMany(int n, int pins) {
        for (int i = 0; i < n; i++) {
            g.roll(pins);
        }
    }

    /**
     * 第2个测试用例，全部1分，得到所有分数相加
     *
     * @throws Exception
     */
    public void testAllOnes() throws Exception {

        for (int i = 0; i < 20; i++) {
            g.roll(1);
        }
        assertEquals(20, g.score());
    }
}
