/**
 * @Title: 1686.石子游戏 VI
 * @TitleSlug: stoneGameVi
 * @Author: Neo
 * @Date: 2024-02-02 17:58:20
 */
package leetcode.editor.cn;

import java.util.Arrays;
import java.util.stream.IntStream;

public class 石子游戏VI {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 石子游戏VI().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int stoneGameVI(int[] aliceValues, int[] bobValues) {
            int n = aliceValues.length;
            Integer[] idx = IntStream.range(0, n).boxed().toArray(Integer[]::new);
            Arrays.sort(idx, (a, b) -> (aliceValues[b] + bobValues[b] - (aliceValues[a] + bobValues[a])));
            int sumA = 0, sumB = 0;
            for (int i = 0; i < n; i++) {
                if ((i & 1) == 0) {
                    sumA += aliceValues[idx[i]];
                } else {
                    sumB += bobValues[idx[i]];
                }
            }
            return sumA == sumB ? 0 : (sumA > sumB ? 1 : -1);
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
        
       