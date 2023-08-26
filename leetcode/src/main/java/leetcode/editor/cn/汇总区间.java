/**
 * @Title: 228.汇总区间
 * @TitleSlug: summaryRanges
 * @Author: Neo
 * @Date: 2023-08-26 09:38:33
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class 汇总区间 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 汇总区间().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> summaryRanges(int[] nums) {
            List<String> ans = new ArrayList<>();
            if(nums.length==0)
            {
                return ans;
            }
            int last = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] != nums[i - 1] + 1) {
                    int l = last, r = nums[i - 1];
                    if (l == r) {
                        ans.add(l + "");
                    } else {
                        ans.add(l + "->" + r);
                    }
                    last = nums[i];
                }
            }
            int l = last, r = nums[nums.length-1];
            if (l == r) {
                ans.add(l + "");
            } else {
                ans.add(l + "->" + r);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       