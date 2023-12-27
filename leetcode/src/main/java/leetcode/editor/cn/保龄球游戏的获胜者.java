/**
 * @Title: 2660.保龄球游戏的获胜者
 * @TitleSlug: determineTheWinnerOfABowlingGame
 * @Author: Neo
 * @Date: 2023-12-27 01:10:19
 */
package leetcode.editor.cn;

public class 保龄球游戏的获胜者 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 保龄球游戏的获胜者().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int isWinner(int[] player1, int[] player2) {
            int sc1 = getScore(player1);
            int sc2 = getScore(player2);
            return sc1 == sc2 ? 0 : sc1 > sc2 ? 1 : 2;
        }

        private int getScore(int[] player1) {
            int cnt = 0,score = 0;
            for (int x : player1) {
                if (cnt > 0) {
                    score += 2 * x;
                    cnt--;
                } else {
                    score += x;
                }
                if (x == 10) {
                    cnt = 2;
                }
            }
            return score;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       