/**
 * @Title: 2465.不同的平均值数目
 * @TitleSlug: numberOfDistinctAverages
 * @Author: Neo
 * @Date: 2023-06-10 14:56:42
 */
package leetcode.editor.cn;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Set;

public class 不同的平均值数目 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 不同的平均值数目().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int distinctAverages(int[] nums) {
            Deque<Integer> d = new ArrayDeque<>();
            Arrays.sort(nums);
            for (int num : nums) {
                d.addLast(num);
            }
            Set<Double> s = new HashSet<>();
            while (!d.isEmpty()) {
                int mn = d.pollFirst();
                int mx = d.pollLast();
                s.add((mn + mx) / 2.0);
            }
            return s.size();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       