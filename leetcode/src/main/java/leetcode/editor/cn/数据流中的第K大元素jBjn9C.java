/**
 * @Title: LCR 059.数据流中的第 K 大元素
 * @TitleSlug: jBjn9C
 * @Author: Neo
 * @Date: 2024-04-11 10:35:15
 */
package leetcode.editor.cn;

import java.util.Arrays;

public class 数据流中的第K大元素jBjn9C {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 数据流中的第K大元素jBjn9C().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class KthLargest {
        private int[] cache;
        private int size, cur;
        
        public KthLargest(int k, int[] nums) {
            size = k;
            cache = new int[size + 1];
            Arrays.fill(cache, Integer.MIN_VALUE);
            for (int num : nums) {
                add(num);
            }
        }
        
        public int add(int val) {
            int i = cur;
            while (i >= 0 && val > cache[i]) {
                cache[i + 1] = cache[i];
                i--;
            }
            cache[i + 1] = val;
            if (cur < size - 1) {
                cur++;
            }
            return cache[size - 1];
        }
    }

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
// leetcode submit region end(Prohibit modification and deletion)

}
       