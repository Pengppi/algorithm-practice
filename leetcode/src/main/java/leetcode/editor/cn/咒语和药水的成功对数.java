/**
 * @Title: 2300.咒语和药水的成功对数
 * @TitleSlug: successfulPairsOfSpellsAndPotions
 * @Author: Neo
 * @Date: 2023-11-10 14:18:12
 */
package leetcode.editor.cn;

import java.util.Arrays;

public class 咒语和药水的成功对数 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 咒语和药水的成功对数().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] successfulPairs(int[] spells, int[] potions, long success) {
            int n = spells.length, m = potions.length;
            int[] pairs = new int[n];
            Arrays.sort(potions);
            for (int i = 0; i < n; i++) {
                int l = 0, r = m;
                while (l < r) {
                    int mid = l + (r - l) / 2;
                    if ((long) spells[i] * potions[mid] >= success) {
                        r = mid;
                    } else {
                        l = mid + 1;
                    }
                }
                pairs[i] = m - l;
            }
            return pairs;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       