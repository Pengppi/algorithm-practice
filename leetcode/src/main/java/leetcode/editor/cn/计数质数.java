/**
 * @Title: 204.计数质数
 * @TitleSlug: countPrimes
 * @Author: Neo
 * @Date: 2023-07-06 20:24:44
 */
package leetcode.editor.cn;

import java.util.Arrays;

public class 计数质数 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 计数质数().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countPrimes(int n) {
            int[] isPrime = new int[n];
            Arrays.fill(isPrime, 1);
            int ans = 0;
            for (int i = 2; i < n; i++) {
                if (isPrime[i] == 1) {
                    ans++;
                    if ((long) i * i < n) {
                        for (int j = i * i; j < n; j += i) {
                            isPrime[j] = 0;
                        }
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       