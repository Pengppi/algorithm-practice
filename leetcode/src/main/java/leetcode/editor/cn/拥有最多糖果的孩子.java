/**
 * @Title: 1431.拥有最多糖果的孩子
 * @TitleSlug: kidsWithTheGreatestNumberOfCandies
 * @Author: Neo
 * @Date: 2023-10-20 23:46:09
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 拥有最多糖果的孩子 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 拥有最多糖果的孩子().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
            List<Boolean> ans = new ArrayList<>();
            int curMax = Arrays.stream(candies).max().getAsInt();
            for (int i : candies) {
                if (i + extraCandies >= curMax) {
                    ans.add(true);
                } else {
                    ans.add(false);
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       