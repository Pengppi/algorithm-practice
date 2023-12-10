/**
 * @Title: 2048.下一个更大的数值平衡数
 * @TitleSlug: nextGreaterNumericallyBalancedNumber
 * @Author: Neo
 * @Date: 2023-12-09 16:39:17
 */
package leetcode.editor.cn;

public class 下一个更大的数值平衡数 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 下一个更大的数值平衡数().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int nextBeautifulNumber(int n) {
            for (int i = n+1; i <= 1224444; i++) {
                if (isBalance(i)) {
                    return i;
                }
            }
            return -1;
        }

        private boolean isBalance(int x) {
            int[] count = new int[10];
            while (x > 0) {
                count[x % 10]++;
                x /= 10;
            }
            for (int d = 0; d < 10; ++d) {
                if (count[d] > 0 && count[d] != d) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       