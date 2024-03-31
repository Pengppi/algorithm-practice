/**
 * @Title: 2682.找出转圈游戏输家
 * @TitleSlug: findTheLosersOfTheCircularGame
 * @Author: Neo
 * @Date: 2024-03-31 00:22:54
 */
package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class 找出转圈游戏输家findTheLosersOfTheCircularGame {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 找出转圈游戏输家findTheLosersOfTheCircularGame().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] circularGameLosers(int n, int k) {
            Set<Integer> set = new HashSet<>();
            int cur = 0, i = 0;
            while (set.add(i)) {
                i = (i + ++cur * k) % n;
            }
            int len = n - set.size();
            int[] ans = new int[len];
            for (i = n - 1; i >= 0; i--) {
                if (!set.contains(i)) {
                    ans[--len] = i + 1;
                }
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       