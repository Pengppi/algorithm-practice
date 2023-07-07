/**
 * @Title: 1040.移动石子直到连续 II
 * @TitleSlug: movingStonesUntilConsecutiveIi
 * @Author: Neo
 * @Date: 2023-04-17 15:40:56
 */
package leetcode.editor.cn;

import java.util.Arrays;

public class 移动石子直到连续II {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 移动石子直到连续II().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] numMovesStonesII(int[] stones) {
            Arrays.sort(stones);
            int n = stones.length;
            int l1 = stones[n - 2] - stones[0] - 1 - (n - 3);
            int l2 = stones[n - 1] - stones[1] - 1 - (n - 3);
            int maxMove = Math.max(l1, l2);
            if (l1 == 0 || l2 == 0)
                return new int[]{Math.min(2, maxMove), maxMove};
            int maxCnt = 0;
            for (int left = 0, right = 1; right < n; right++) {
                while (stones[right] - stones[left] + 1 > n) {
                    left++;
                }
                maxCnt = Math.max(maxCnt, right - left + 1);
            }
            return new int[]{n - maxCnt, maxMove};
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}

