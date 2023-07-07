/**
 * @Title: 1638.统计只差一个字符的子串数目
 * @TitleSlug: countSubstringsThatDifferByOneCharacter
 * @Author: Neo
 * @Date: 2023-03-27 15:34:18
 */
package leetcode.editor.cn;

public class 统计只差一个字符的子串数目 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 统计只差一个字符的子串数目().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countSubstrings(String s, String t) {
            int n = s.length();
            int m = t.length();
            int ans = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int diff = 0;
                    int k = 0;
                    while (i + k < n && j + k < m) {
                        if (s.charAt(i + k) != t.charAt(j + k)) {
                            diff++;
                        }
                        if (diff == 1) {
                            ans++;
                        }
                        if (diff == 2) {
                            break;
                        }
                        k++;
                    }
                }
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}
