/**
 * @Title: 2698.求一个整数的惩罚数
 * @TitleSlug: findThePunishmentNumberOfAnInteger
 * @Author: Neo
 * @Date: 2023-06-09 17:48:35
 */
package leetcode.editor.cn;

public class 求一个整数的惩罚数 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 求一个整数的惩罚数().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private static final int[] PRE_SUM = new int[1001];

        static {
            for (int i = 1; i <= 1000; i++) {
                char[] s = String.valueOf(i * i).toCharArray();
                PRE_SUM[i] = PRE_SUM[i - 1] + (dfs(s, i, 0, 0) ? i * i : 0);
            }
        }

        public int punishmentNumber(int n) {
            return PRE_SUM[n];
        }

        private static boolean dfs(char[] s, int i, int p, int sum) {
            if (p == s.length) {
                return sum == i;
            }
            int x = 0;
            for (int j = p; j < s.length; j++) {
                x = x * 10 + s[j] - '0';
                if (dfs(s, i, j + 1, sum + x)) {
                    return true;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       