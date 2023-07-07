/**
 * @Title: 2517.礼盒的最大甜蜜度
 * @TitleSlug: maximumTastinessOfCandyBasket
 * @Author: Neo
 * @Date: 2023-06-01 10:14:42
 */
package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Map;

public class 礼盒的最大甜蜜度 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 礼盒的最大甜蜜度().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumTastiness(int[] price, int k) {
            int n = price.length;
            Arrays.sort(price);
            int l = 0, r = price[n - 1] - price[0];
            while (l <= r) {
                int mid = (l + r) >> 1;
                if (check(price, k, mid)) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            return r;
        }

        private boolean check(int[] arr, int k, int gap) {
            int prev = Integer.MIN_VALUE / 2;
            int cnt = 0;
            for (int x : arr) {
                if (x - prev >= gap) {
                    prev = x;
                    cnt++;
                }
            }
            return cnt >= k;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}
        
       