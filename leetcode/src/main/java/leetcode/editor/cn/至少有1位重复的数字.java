/**
 * @Title: 1012.至少有 1 位重复的数字
 * @TitleSlug: numbersWithRepeatedDigits
 * @Author: Neo
 * @Date: 2023-04-17 15:38:50
 */
package leetcode.editor.cn;

public class 至少有1位重复的数字 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 至少有1位重复的数字().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numDupDigitsAtMostN(int n) {
            return n - f(Integer.toString(n).toCharArray(), 0, 0, true, false);
        }

        public int f(char[] cs, int i, int mask, boolean is_limit, boolean have_num) {
            if (i == cs.length) {
                return have_num ? 1 : 0;
            }
            int res = 0;
            if (!have_num) {
                res = f(cs, i + 1, mask, false, false);
            }
            int start_num = have_num ? 0 : 1;
            int up_num = is_limit ? cs[i] - '0' : 9;
            for (; start_num <= up_num; start_num++) {
                if ((mask >> start_num & 1) == 0) {
                    res += f(cs, i + 1, mask | (1 << start_num), is_limit && start_num == up_num, true);
                }
            }
            return res;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}

