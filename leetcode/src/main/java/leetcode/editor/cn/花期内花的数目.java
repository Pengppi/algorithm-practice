/**
 * @Title: 2251.花期内花的数目
 * @TitleSlug: numberOfFlowersInFullBloom
 * @Author: Neo
 * @Date: 2023-09-28 11:08:04
 */
package leetcode.editor.cn;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 花期内花的数目 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 花期内花的数目().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] fullBloomFlowers(int[][] flowers, int[] people) {
            Arrays.sort(flowers, (a, b) -> (a[0] - b[0]));
            int n = people.length;
            int[][] p = new int[n][2];
            for (int i = 0; i < n; i++) {
                p[i][0] = people[i];
                p[i][1] = i;
            }
            Arrays.sort(p, (a, b) -> (a[0] - b[0]));
            int i = 0, j = 0, m = flowers.length;
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            int[] tmp = new int[n];
            while (j < n) {
                int curTime = p[j][0];
                while (i < m && flowers[i][0] <= curTime) {
                    pq.offer(flowers[i][1]);
                    i++;
                }
                while (!pq.isEmpty()&&pq.peek() < curTime) {
                    pq.poll();
                }
                tmp[j] = pq.size();
                j++;
            }
            int[] ans = new int[n];
            for (i = 0; i < n; i++) {
                ans[p[i][1]] = tmp[i];
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       