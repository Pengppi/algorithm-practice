/**
 * @Title: 1318.或运算的最小翻转次数
 * @TitleSlug: minimumFlipsToMakeAOrBEqualToC
 * @Author: Neo
 * @Date: 2023-11-18 10:46:36
 */
package leetcode.editor.cn;

public class 或运算的最小翻转次数 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 或运算的最小翻转次数().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minFlips(int a, int b, int c) {
            int cnt = 0;
            for (int i = 0; i < 32; i++) {
                int cc = (c >> i) & 1;
                int aa = (a >> i) & 1;
                int bb = (b >> i) & 1;
                if (cc == 0) {
                    if (aa != 0) {
                        cnt++;
                    }
                    if (bb != 0) {
                        cnt++;
                    }
                } else {
                    if (aa == 0 && bb == 0) {
                        cnt++;
                    }
                }
            }
            return cnt;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       