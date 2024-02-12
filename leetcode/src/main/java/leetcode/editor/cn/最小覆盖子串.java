/**
 * @Title: 76.最小覆盖子串
 * @TitleSlug: minimumWindowSubstring
 * @Author: Neo
 * @Date: 2024-02-11 23:37:54
 */
package leetcode.editor.cn;

public class 最小覆盖子串 {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 最小覆盖子串().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minWindow(String s, String t) {
            int[] c1 = new int[60], c2 = new int[60];
            int tot = 0;
            for (final char c : t.toCharArray()) {
                if (++c2[getIdx(c)] == 1) {
                    tot++;
                }
            }
            String ans = "";
            for (int i = 0, j = 0; i < s.length(); i++) {
                int idx1 = getIdx(s.charAt(i));
                if (++c1[idx1] == c2[idx1]) {
                    tot--;
                }
                while (j < i) {
                    int idx2 = getIdx(s.charAt(j));
                    if (c1[idx2] > c2[idx2]) {
                        --c1[idx2];
                        j++;
                    } else {
                        break;
                    }
                }
                if (tot == 0 && (ans.length() > i - j + 1 || ans.length() == 0)) {
                    ans = s.substring(j, i + 1);
                }
            }
            return ans;
        }
        
        private int getIdx(char c) {
            return c >= 'A' && c <= 'Z' ? c - 'A' + 26 : c - 'a';
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
        
       