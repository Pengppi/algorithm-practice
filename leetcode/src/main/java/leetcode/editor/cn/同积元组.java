/**
 * @Title: 1726.同积元组
 * @TitleSlug: tupleWithSameProduct
 * @Author: Neo
 * @Date: 2023-10-19 15:08:57
 */
package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class 同积元组 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 同积元组().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int tupleSameProduct(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            int n = nums.length, ans = 0;
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    int k = nums[i] * nums[j];
                    int cnt = map.getOrDefault(k,0);
                    ans += cnt * 8;
                    map.put(k, cnt + 1);
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       