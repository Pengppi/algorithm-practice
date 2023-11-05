/**
 * @Title: 1657.确定两个字符串是否接近
 * @TitleSlug: determineIfTwoStringsAreClose
 * @Author: Neo
 * @Date: 2023-11-05 17:49:33
 */
package leetcode.editor.cn;

import java.util.Arrays;

public class 确定两个字符串是否接近 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 确定两个字符串是否接近().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean closeStrings(String word1, String word2) {
            if (word1.length() != word2.length()) {
                return false;
            }
            int[] ch1 = new int[26];
            int[] ch2 = new int[26];
            for (char c : word1.toCharArray()) {
                ch1[c - 'a']++;
            }
            for (char c : word2.toCharArray()) {
                ch2[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                if (ch1[i] != ch2[i]) {
                    if (ch1[i] == 0 || ch2[i] == 0) {
                        return false;
                    }
                }
            }
            Arrays.sort(ch1);
            Arrays.sort(ch2);
            for (int i = 0; i < 26; i++) {
                if (ch1[i] != ch2[i]) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       