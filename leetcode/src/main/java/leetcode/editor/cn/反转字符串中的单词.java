/**
 * @Title: 151.反转字符串中的单词
 * @TitleSlug: reverseWordsInAString
 * @Author: Neo
 * @Date: 2023-10-31 23:17:40
 */
package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 反转字符串中的单词 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 反转字符串中的单词().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseWords(String s) {
            List<String> list = Arrays.asList(s.trim().split("\\s+"));
            Collections.reverse(list);
            return String.join(" ", list);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       