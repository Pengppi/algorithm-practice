/**
 * @Title: 292.Nim 游戏
 * @TitleSlug: NimGame
 * @Author: Neo
 * @Date: 2022-10-27 14:12:15
 */
package leetcode.editor.cn;

public class Nim游戏 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new Nim游戏().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canWinNim(int n) {
            return n % 4 != 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
