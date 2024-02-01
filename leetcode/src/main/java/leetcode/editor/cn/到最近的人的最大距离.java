/**
 * @Title: 849.到最近的人的最大距离
 * @TitleSlug: maximizeDistanceToClosestPerson
 * @Author: Neo
 * @Date: 2024-01-31 09:46:53
 */
package leetcode.editor.cn;

public class 到最近的人的最大距离 {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 到最近的人的最大距离().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxDistToClosest(int[] seats) {
            int n = seats.length;
            int[] left = new int[n];
            int last = -n;
            for (int i = 0; i < n; i++) {
                if (seats[i] == 0) {
                    left[i] = i - last;
                } else {
                    last = i;
                }
            }
            last = 2 * n;
            int maxDistance = 0;
            for (int i = n - 1; i >= 0; i--) {
                if (seats[i] == 0) {
                    int right = last - i;
                    int curDistance = Math.min(left[i], right);
                    maxDistance = Math.max(maxDistance, curDistance);
                } else {
                    last = i;
                }
            }
            return maxDistance;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
        
       