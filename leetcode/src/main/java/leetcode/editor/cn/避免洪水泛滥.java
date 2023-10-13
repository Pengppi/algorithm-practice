/**
 * @Title: 1488.避免洪水泛滥
 * @TitleSlug: avoidFloodInTheCity
 * @Author: Neo
 * @Date: 2023-10-13 15:27:00
 */
package leetcode.editor.cn;

import java.util.*;

public class 避免洪水泛滥 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 避免洪水泛滥().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] avoidFlood(int[] rains) {
            TreeSet<Integer> set = new TreeSet<>();
            int n = rains.length;
            int[] ans = new int[n];
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                if (rains[i] == 0) {
                    set.add(i);
                    ans[i] = 1;
                } else {
                    ans[i] = -1;
                    if (map.containsKey(rains[i])) {
                        Integer c = set.ceiling(map.get(rains[i]));
                        if (c == null) {
                            return new int[0];
                        }
                        ans[c] = rains[i];
                        set.remove(c);
                    }
                    map.put(rains[i], i);
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       