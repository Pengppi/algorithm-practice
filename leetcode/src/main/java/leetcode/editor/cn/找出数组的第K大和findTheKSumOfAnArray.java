/**
 * @Title: 2386.找出数组的第 K 大和
 * @TitleSlug: findTheKSumOfAnArray
 * @Author: Neo
 * @Date: 2024-03-09 00:21:01
 */
package leetcode.editor.cn;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 找出数组的第K大和findTheKSumOfAnArray {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 找出数组的第K大和findTheKSumOfAnArray().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long kSum(int[] nums, int k) {
            long sum = 0;
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                if (nums[i] > 0) {
                    sum += nums[i];
                } else {
                    nums[i] = -nums[i];
                }
            }
            Arrays.sort(nums);
            PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Long.compare(a.key, b.key));
            pq.offer(new Pair(0L, -1));
            while (--k > 0) {
                Pair p = pq.poll();
                long num = p.key;
                int i = p.val;
                if (i + 1 < n) {
                    pq.offer(new Pair(num + nums[i + 1], i + 1));
                    if (i >= 0) {
                        pq.offer(new Pair(num + nums[i + 1] - nums[i], i + 1));
                    }
                }
            }
            return sum - pq.peek().key;
        }
        
        class Pair {
            Long key;
            Integer val;
            
            public Pair(Long key, Integer val) {
                this.key = key;
                this.val = val;
            }
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       