/**
 * @Title: 219.存在重复元素 II
 * @TitleSlug: containsDuplicateIi
 * @Author: Neo
 * @Date: 2023-12-01 14:13:18
 */
package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class 存在重复元素II {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 存在重复元素II().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(nums[i])) {
                    int j = map.get(nums[i]);
                    if (i - j <= k) {
                        return true;
                    }
                }
                map.put(nums[i], i);
            }

            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       