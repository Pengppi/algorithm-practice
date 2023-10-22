/**
 * @Title: 1402.做菜顺序
 * @TitleSlug: reducingDishes
 * @Author: Neo
 * @Date: 2023-10-22 14:11:33
 */
package leetcode.editor.cn;

import java.util.Arrays;

public class 做菜顺序 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 做菜顺序().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSatisfaction(int[] satisfaction) {
            Arrays.sort(satisfaction);
            int f = 0, s = 0;
            for (int i = satisfaction.length - 1; i >= 0; i--) {
                s += satisfaction[i];
                if (s <= 0) {
                    break;
                }
                f += s;
            }
            return f;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       