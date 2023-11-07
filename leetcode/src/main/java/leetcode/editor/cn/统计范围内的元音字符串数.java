/**
 * @Title: 2586.统计范围内的元音字符串数
 * @TitleSlug: countTheNumberOfVowelStringsInRange
 * @Author: Neo
 * @Date: 2023-11-07 13:41:40
 */
package leetcode.editor.cn;

public class 统计范围内的元音字符串数 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 统计范围内的元音字符串数().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int vowelStrings(String[] words, int left, int right) {
            int ans = 0;
            for (int i = left; i <= right; i++) {
                if (isVowel(words[i].charAt(0)) && isVowel(words[i].charAt(words[i].length() - 1))) {
                    ans++;
                }
            }
            return ans;
        }

        private boolean isVowel(char ch) {
            return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       