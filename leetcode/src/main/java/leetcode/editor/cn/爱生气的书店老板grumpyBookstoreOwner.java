/**
 * @Title: 1052.爱生气的书店老板
 * @TitleSlug: grumpyBookstoreOwner
 * @Author: Neo
 * @Date: 2024-04-23 00:36:24
 */
package leetcode.editor.cn;

public class 爱生气的书店老板grumpyBookstoreOwner {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 爱生气的书店老板grumpyBookstoreOwner().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
            int n = customers.length;
            int total = 0, maxAngry = 0, currentAngry = 0;
            for (int i = 0; i < n; i++) {
                if (i >= minutes && grumpy[i - minutes] == 1) {
                    currentAngry -= customers[i - minutes];
                }
                if (grumpy[i] == 1) {
                    currentAngry += customers[i];
                } else {
                    total += customers[i];
                }
                maxAngry = Math.max(maxAngry, currentAngry);
            }
            return total + maxAngry;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       