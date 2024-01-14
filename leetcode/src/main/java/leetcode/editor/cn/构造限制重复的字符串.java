/**
 * @Title: 2182.构造限制重复的字符串
 * @TitleSlug: constructStringWithRepeatLimit
 * @Author: Neo
 * @Date: 2024-01-13 22:32:56
 */
package leetcode.editor.cn;

public class 构造限制重复的字符串 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 构造限制重复的字符串().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String repeatLimitedString(String s, int repeatLimit) {
            int[] cnt = new int[26];
            for (char c : s.toCharArray()) {
                cnt[c - 'a']++;
            }
            var ans = new StringBuilder();
            int repeat = 0;
            for (int i = 25, j = 24; i >= 0 && j >= 0; ) {
                if (cnt[i] == 0) {
                    repeat = 0;
                    i--;
                } else if (repeat < repeatLimit) {
                    ans.append((char) (i + 'a'));
                    repeat++;
                    cnt[i]--;
                } else if (j >= i || cnt[j] == 0) {
                    j--;
                } else {
                    ans.append((char) (j + 'a'));
                    cnt[j]--;
                    repeat = 0;
                }
            }
            return ans.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       