/**
 * @Title: 2178.拆分成最多数目的正偶数之和
 * @TitleSlug: maximumSplitOfPositiveEvenIntegers
 * @Author: Neo
 * @Date: 2023-07-06 18:07:10
 */
package leetcode.editor.cn;

import java.util.ArrayList;

public class 拆分成最多数目的正偶数之和 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 拆分成最多数目的正偶数之和().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<Long> maximumEvenSplit(long finalSum) {
            List<Long> ans = new ArrayList<>();
            if (finalSum % 2 != 0) {
                return ans;
            }

            for (long i = 2; i <= finalSum; i += 2) {
                ans.add(i);
                finalSum -= i;
            }
            ans.set(ans.size() - 1, ans.get(ans.size() - 1) + finalSum);
            return ans;

        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       