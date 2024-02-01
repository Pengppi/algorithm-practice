/**
 * @Title: 2337.移动片段得到字符串
 * @TitleSlug: movePiecesToObtainAString
 * @Author: Neo
 * @Date: 2024-01-31 09:57:51
 */
package leetcode.editor.cn;

public class 移动片段得到字符串 {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 移动片段得到字符串().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canChange(String start, String target) {
            int n = start.length();
            int i = 0, j = 0;
            while (i < n && j < n) {
                while (i < n && start.charAt(i) == '_') {
                    i++;
                }
                while (j < n && target.charAt(j) == '_') {
                    j++;
                }
                if (i < n && j < n) {
                    if (start.charAt(i) != target.charAt(j)) {
                        return false;
                    }
                    char c = start.charAt(i);
                    if ((c == 'L' && i < j) || (c == 'R' && i > j)) {
                        return false;
                    }
                    i++;
                    j++;
                }
            }
            while (i < n) {
                if (start.charAt(i++) != '_') {
                    return false;
                }
            }
            while (j < n) {
                if (target.charAt(j++) != '_') {
                    return false;
                }
            }
            return true;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
        
       