/**
 * @Title: 1003.检查替换后的词是否有效
 * @TitleSlug: checkIfWordIsValidAfterSubstitutions
 * @Author: Neo
 * @Date: 2023-05-03 15:24:43
 */
package leetcode.editor.cn;

public class 检查替换后的词是否有效 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 检查替换后的词是否有效().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            while (s.contains("abc")) {
                s = s.replace("abc", "");
            }
            return s.isEmpty();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
        
       