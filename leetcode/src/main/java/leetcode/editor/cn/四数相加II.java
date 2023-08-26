/**
 * @Title: 454.四数相加 II
 * @TitleSlug: fourSumIi
 * @Author: Neo
 * @Date: 2023-08-24 23:57:21
 */
package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class 四数相加II {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 四数相加II().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
            int n = nums1.length;
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                int a = nums1[i];
                for (int j = 0; j < n; j++) {
                    int b = nums2[j];
                    map.put(a + b, map.getOrDefault(a + b, 0) + 1);
                }
            }
            int ans = 0;
            for (int k = 0; k < n; k++) {
                int c = nums3[k];
                for (int l = 0; l < n; l++) {
                    int d = nums4[l];
                    ans += map.getOrDefault(-c - d, 0);
                }
            }
            return ans;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       