/**
 * @Title: 2490.回环句
 * @TitleSlug: circularSentence
 * @Author: Neo
 * @Date: 2023-06-30 23:26:31
 */
package leetcode.editor.cn;

public class 回环句 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 回环句().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isCircularSentence(String sentence) {
            String[] words = sentence.split(" ");
            int n = words.length;
            for (int i = 0; i < n - 1; i++) {
                int len = words[i].length();
                if (words[i].charAt(len - 1) != words[i + 1].charAt(0)) {
                    return false;
                }
            }
            return words[n - 1].charAt(words[n - 1].length() - 1) == words[0].charAt(0);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       