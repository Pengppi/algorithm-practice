/**
 * @Title: 1033.移动石子直到连续
 * @TitleSlug: movingStonesUntilConsecutive
 * @Author: Neo
 * @Date: 2023-04-30 13:15:04
 */
package leetcode.editor.cn;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 移动石子直到连续 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 移动石子直到连续().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] numMovesStones(int a, int b, int c) {
            int[] pos = new int[]{a, b, c};
            Arrays.sort(pos);
            int max = pos[2] - pos[1] - 1 + pos[1] - pos[0] - 1;
            int min = 0;
            if (pos[2] - pos[1] == 1 && pos[1] - pos[0] == 1) {
                min = 0;
            } else if ((pos[2] - pos[1] <= 2 || pos[1] - pos[0] <= 2)) {
                min = 1;
            } else {
                min = 2;
            }
            return new int[]{min, max};

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
        
       