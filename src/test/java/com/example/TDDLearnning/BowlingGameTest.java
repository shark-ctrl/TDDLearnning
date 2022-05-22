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
        rollSpare();
        //第二局投了一个三分
        g.roll(3);
//        第2局第2投0分，后面都是0分，第10局必须打满10分才能奖励一投，所以总投数为20
        rollMany(17, 0);
        assertEquals(16, g.score());
    }


    private void rollSpare() {
        g.roll(5);
        g.roll(5);
    }

    public void testOneStrike() {
        //第一局Strike 得分为10+后面两球得到即17
        rollStrike();
//        第二局3 4
        g.roll(3);
        g.roll(4);
        //其余都是0分
        rollMany(16, 0);
        assertEquals(24, g.score());
    }

    private void rollStrike() {
        g.roll(10);
    }


    public void testPerfectGame() {
//        因为都投出10，根据规则拿到10分的那局分数=10+后面两球分数，以及最后一局拿到10分可以投三球，所以得分应该是
        /**
         * 1:10 +(10+10)
         * 2:10 +(10+10)
         * 3:10 +(10+10)
         * 4:10 +(10+10)
         * 5:10 +(10+10)
         * 6:10 +(10+10)
         * 7:10 +(10+10)
         * 8:10 +(10+10)
         * 9:10 +(10+10)
         * 10:10 +(10+10)
         */
//        n=12 是因为前9局各一球 最后一句striker投了3球
        rollMany(12, 10);
    }
}
