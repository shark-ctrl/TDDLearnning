package com.example.TDDLearnning;

import com.example.TDDLearnning.BowlingGame.Game;
import junit.framework.TestCase;

public class BowlingGameTest extends TestCase {

    private Game g;

    /**
     * 跑每个测试单元前，都会执行的方法
     *
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

        rollMany(20, 1);
        assertEquals(20, g.score());
    }

//    /**
//     * 测试第一次两投得到10分,其余都是0分，所以总得分应该是第1局分数+后1投分数 +后续得分=16
//     *
//     * @throws Exception
//     */
    public void testOneSpare() throws Exception {
        //第一局投了10分
        g.roll(5);
        g.roll(5);
        //第二局投了一个三分
        g.roll(3);
//        第2局第2投0分，后面都是0分，第10局必须打满10分才能奖励一投，所以总投数为20
        rollMany(17, 0);
        assertEquals(16, g.score());
    }
}
