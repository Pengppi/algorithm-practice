/**
 * @Title: 2828.判别首字母缩略词
 * @TitleSlug: checkIfAStringIsAnAcronymOfWords
 * @Author: Neo
 * @Date: 2023-12-20 00:11:12
 */
package leetcode.editor.cn;

import java.util.List;

public class 判别首字母缩略词 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 判别首字母缩略词().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isAcronym(List<String> words, String s) {
            if (words.size() != s.length()) {
                return false;
            }
            int n = s.length();
            char[] chars = s.toCharArray();
            for (int i = 0; i < n; i++) {
                if (words.get(i).charAt(0) != chars[i]) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       