/**
 * @Title: 670.最大交换
 * @TitleSlug: MaximumSwap
 * @Author: Neo
 * @Date: 2022-10-28 14:44:44
 */
package leetcode.editor.cn;

public class 最大交换 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 最大交换().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumSwap(int num) {
            char[] cs = String.valueOf(num).toCharArray();
            int n = cs.length;
            int mx = n - 1;
            int i1 = -1, i2 = -1;
            for (int i = n - 1; i >= 0; i--) {
                if (cs[i] > cs[mx]) {
                    mx = i;
                } else if (cs[i] < cs[mx]) {
                    i1 = i;
                    i2 = mx;
                }
            }
            if (i1 >= 0) {
                char t = cs[i1];
                cs[i1] = cs[i2];
                cs[i2] = t;
            }
            return Integer.parseInt(new String(cs));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
