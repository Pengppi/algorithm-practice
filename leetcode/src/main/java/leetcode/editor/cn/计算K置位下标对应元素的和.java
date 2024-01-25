/**
 * @Title: 2859.计算 K 置位下标对应元素的和
 * @TitleSlug: sumOfValuesAtIndicesWithKSetBits
 * @Author: Neo
 * @Date: 2024-01-25 09:17:35
 */
package leetcode.editor.cn;

import java.util.List;

public class 计算K置位下标对应元素的和 {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 计算K置位下标对应元素的和().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
            int n = nums.size(), sum = 0;
            for (int i = 0; i < n; i++) {
                if (Integer.bitCount(i) == k) {
                    sum += nums.get(i);
                }
            }
            return sum;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
        
       