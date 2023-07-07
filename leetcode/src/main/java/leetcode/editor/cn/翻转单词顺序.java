/**
 * @Title: 剑指 Offer 58 - I.翻转单词顺序
 * @TitleSlug: fanZhuanDanCiShunXuLcof
 * @Author: Neo
 * @Date: 2023-05-12 14:40:22
 */
package leetcode.editor.cn;

import java.util.Arrays;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class 翻转单词顺序 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 翻转单词顺序().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseWords(String s) {
            StringBuilder sb = new StringBuilder();
            StringBuilder word = new StringBuilder();
            s += " ";
            for (char c : s.toCharArray()) {
                if (c == ' ') {
                    if (word.length() > 0) {
                        sb.insert(0, word.toString() + " ");
                        word = new StringBuilder();
                    }
                } else {
                    word.append(c);
                }
            }
            return sb.toString().trim();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
        
       