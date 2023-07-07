/**
 * @Title: 1090.受标签影响的最大值
 * @TitleSlug: largestValuesFromLabels
 * @Author: Neo
 * @Date: 2023-05-23 12:07:41
 */
package leetcode.editor.cn;

import java.util.HashMap;
import java.util.PriorityQueue;

public class 受标签影响的最大值 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 受标签影响的最大值().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[1] - a[1]));
            int n = values.length;
            for (int i = 0; i < n; i++) {
                pq.add(new int[]{labels[i], values[i]});
            }
            int ans = 0, size = 0;
            Map<Integer, Integer> map = new HashMap<>();
            while (!pq.isEmpty() && size < numWanted) {
                int[] t = pq.poll();
                int count = map.getOrDefault(t[0], 0);
                if (count < useLimit) {
                    ans += t[1];
                    map.put(t[0], count + 1);
                    size++;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       