/**
 * @Title: 2808.使循环数组所有元素相等的最少秒数
 * @TitleSlug: minimumSecondsToEqualizeACircularArray
 * @Author: Neo
 * @Date: 2024-01-30 09:26:10
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class 使循环数组所有元素相等的最少秒数{
public static void main(String[] args) {
        //测试代码
        //Solution solution = new 使循环数组所有元素相等的最少秒数().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumSeconds(List<Integer> nums) {
        HashMap<Integer, List<Integer>> mp = new HashMap<>();
        int n = nums.size(), res = n;
        for (int i = 0; i < n; ++i) {
            mp.computeIfAbsent(nums.get(i), k -> new ArrayList<>()).add(i);
        }
        for (List<Integer> positions : mp.values()) {
            int mx = positions.get(0) + n - positions.get(positions.size() - 1);
            for (int i = 1; i < positions.size(); ++i) {
                mx = Math.max(mx, positions.get(i) - positions.get(i - 1));
            }
            res = Math.min(res, mx / 2);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
        
       