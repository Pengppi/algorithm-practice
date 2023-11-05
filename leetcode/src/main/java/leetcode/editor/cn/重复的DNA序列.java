/**
 * @Title: 187.重复的DNA序列
 * @TitleSlug: repeatedDnaSequences
 * @Author: Neo
 * @Date: 2023-11-05 17:39:43
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 重复的DNA序列 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 重复的DNA序列().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> findRepeatedDnaSequences(String s) {
            int n = s.length(), l = 10;
            Map<String, Integer> map = new HashMap<>();
            List<String> ans = new ArrayList<>();
            for (int i = 0; i <= n - l; i++) {
                String k = s.substring(i, i + l);
                map.put(k, map.getOrDefault(k, 0) + 1);
            }
            for (String k : map.keySet()) {
                if (map.get(k) > 1) {
                    ans.add(k);
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       