/**
 * @Title: 2103.环和杆
 * @TitleSlug: ringsAndRods
 * @Author: Neo
 * @Date: 2023-11-02 00:33:38
 */
package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class 环和杆 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 环和杆().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countPoints(String rings) {
            char[] cArr = rings.toCharArray();
            int n = cArr.length;
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i += 2) {
                char c = cArr[i];
                int k = cArr[i + 1] - '0';
                int val = map.getOrDefault(k, 0);
                if (c == 'R') {
                    val |= 1;
                } else if (c == 'G') {
                    val |= 1 << 1;
                } else {
                    val |= 1 << 2;
                }
                map.put(k, val);
            }
            int ans = 0;
            for (Integer v : map.values()) {
                if (v == 7) {
                    ans++;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       