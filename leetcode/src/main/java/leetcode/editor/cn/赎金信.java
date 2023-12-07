/**
 * @Title: 383.赎金信
 * @TitleSlug: ransomNote
 * @Author: Neo
 * @Date: 2023-12-07 00:44:18
 */
package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class 赎金信 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 赎金信().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canConstruct(String ransomNote, String magazine) {
            if (ransomNote.length() > magazine.length()) {
                return false;
            }
            Map<Character, Integer> map = new HashMap<>();
            for (char c : magazine.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            for (char c : ransomNote.toCharArray()) {
                if (map.getOrDefault(c, 0) <= 0) {
                    return false;
                }
                map.put(c, map.get(c) - 1);
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       