/**
 * @Title: 2007.从双倍数组中还原原数组
 * @TitleSlug: findOriginalArrayFromDoubledArray
 * @Author: Neo
 * @Date: 2024-04-18 11:52:35
 */
package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 从双倍数组中还原原数组findOriginalArrayFromDoubledArray {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 从双倍数组中还原原数组findOriginalArrayFromDoubledArray().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] findOriginalArray(int[] changed) {
            int n = changed.length;
            if ((n & 1) == 1) {
                return new int[0];
            }
            Map<Integer, Integer> map = new HashMap<>();
            int[] ans = Arrays.stream(changed).sorted().filter(x -> {
                if (!map.containsKey(x)) {
                    map.merge(x * 2, 1, Integer::sum);
                    return true;
                } else {
                    int cnt = map.merge(x, -1, Integer::sum);
                    if (cnt == 0) {
                        map.remove(x);
                    }
                    return false;
                }
            }).toArray();
            return ans.length == n / 2 ? ans : new int[0];
        }
    }
// leetcode submit region end(Prohibit modification and deletion)
}
       