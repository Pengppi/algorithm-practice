/**
 * @Title: 17.电话号码的字母组合
 * @TitleSlug: letterCombinationsOfAPhoneNumber
 * @Author: Neo
 * @Date: 2024-04-13 00:38:34
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class 电话号码的字母组合letterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 电话号码的字母组合letterCombinationsOfAPhoneNumber().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private static final String[] KEYS = new String[]{
                "",     // 0
                "",     // 1
                "abc",  // 2
                "def",  // 3
                "ghi",  // 4
                "jkl",  // 5
                "mno",  // 6
                "pqrs", // 7
                "tuv",  // 8
                "wxyz"  // 9
        };
        
        public List<String> letterCombinations(String digits) {
            return backtracking(digits, 0, new StringBuilder(), new ArrayList<>());
        }
        
        private List<String> backtracking(String digits, int i, StringBuilder sb, List<String> res) {
            if (i == digits.length()) {
                if (!sb.isEmpty()) {
                    res.add(sb.toString());
                }
                return res;
            }
            int digit = digits.charAt(i) - '0';
            for (char c : KEYS[digit].toCharArray()) {
                sb.append(c);
                backtracking(digits, i + 1, sb, res);
                sb.deleteCharAt(sb.length() - 1);
            }
            return res;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       