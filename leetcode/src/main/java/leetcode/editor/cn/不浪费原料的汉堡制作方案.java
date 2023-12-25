/**
 * @Title: 1276.不浪费原料的汉堡制作方案
 * @TitleSlug: numberOfBurgersWithNoWasteOfIngredients
 * @Author: Neo
 * @Date: 2023-12-25 00:42:04
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class 不浪费原料的汉堡制作方案 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 不浪费原料的汉堡制作方案().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
            if ((tomatoSlices & 1) != 0) {
                return new ArrayList<>();
            }
            List<Integer> ans = new ArrayList<>();
            int a = tomatoSlices / 2 - cheeseSlices;
            int b = cheeseSlices - a;
            if (a < 0 || b < 0) {
                return new ArrayList<>();
            }
            ans.add(a);
            ans.add(b);
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       