/**
 * @Title: 1015.可被 K 整除的最小整数
 * @TitleSlug: smallestIntegerDivisibleByK
 * @Author: Neo
 * @Date: 2023-05-10 10:36:07
 */
package leetcode.editor.cn;

import java.math.BigInteger;
import java.util.HashSet;

public class 可被K整除的最小整数 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 可被K整除的最小整数().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int smallestRepunitDivByK(int k) {
            int n = 1 % k;
            for (int i = 1; i <= k; i++) {
                if (n == 0) {
                    return i;
                }
                n = (10 * n + 1) % k;
            }

            return -1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
        
       