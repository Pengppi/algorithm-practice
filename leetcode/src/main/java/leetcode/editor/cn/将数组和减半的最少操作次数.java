/**
 * @Title: 2208.将数组和减半的最少操作次数
 * @TitleSlug: minimumOperationsToHalveArraySum
 * @Author: Neo
 * @Date: 2023-07-25 17:49:18
 */
package leetcode.editor.cn;

import java.util.PriorityQueue;

public class 将数组和减半的最少操作次数 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 将数组和减半的最少操作次数().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int halveArray(int[] nums) {
            PriorityQueue<Double> queue = new PriorityQueue<>((a, b) -> (Double.compare(b, a)));
            double sum = 0;
            for (int num : nums) {
                sum += num;
                queue.offer((double) num);
            }
            double target = sum / 2.0;
            int ans = 0;
            while (sum > target) {
                double maxValue = queue.poll();
                maxValue = maxValue / 2.0;
                sum -= maxValue;
                queue.offer(maxValue);
                ans++;
            }
            return ans;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       