/**
 * @Title: 481.神奇字符串
 * @TitleSlug: MagicalString
 * @Author: Neo
 * @Date: 2022-10-31 09:00:19
 */
package leetcode.editor.cn;

public class 神奇字符串 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 神奇字符串().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int magicalString(int n) {
            int ans = 1;
            if (n < 4) {
                return ans;
            }
            char[] cs = new char[n];
            cs[0] = '1';
            cs[1] = '2';
            cs[2] = '2';
            int i = 2, j = 3;
            while (j < n) {
                char t = (char) ('3' - cs[j - 1] + '0');
                int cnt = cs[i] - '0';
                for (int k = 0; k < cnt && j < n; k++, j++) {
                    cs[j] = t;
                    if (t == '1') {
                        ans++;
                    }
                }
                i++;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
