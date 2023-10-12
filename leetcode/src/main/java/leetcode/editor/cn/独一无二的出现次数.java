/**
 * @Title: 1207.独一无二的出现次数
 * @TitleSlug: uniqueNumberOfOccurrences
 * @Author: Neo
 * @Date: 2023-10-12 00:46:28
 */
package leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class 独一无二的出现次数 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 独一无二的出现次数().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean uniqueOccurrences(int[] arr) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int x : arr) {
                map.put(x, map.getOrDefault(x, 0) + 1);
            }
            Set<Integer> set = new HashSet<>();
            for (Integer v : map.values()) {
                if (!set.add(v)) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       