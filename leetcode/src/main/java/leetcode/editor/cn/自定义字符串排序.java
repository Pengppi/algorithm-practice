/**
 * @Title: 791.自定义字符串排序
 * @TitleSlug: CustomSortString
 * @Author: Neo
 * @Date: 2022-11-13 10:35:21
 */
package leetcode.editor.cn;

public class 自定义字符串排序 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 自定义字符串排序().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String customSortString(String order, String s) {
            int[] alpha = new int[26];
            for (char c : s.toCharArray()) {
                int t = c - 'a';
                alpha[t]++;
            }
            StringBuilder sb = new StringBuilder();
            for (char c : order.toCharArray()) {
                int t = c - 'a';
                while (alpha[t] > 0) {
                    sb.append(c);
                    alpha[t]--;
                }
            }
            for (int i = 0; i < 26; i++) {
                while (alpha[i] > 0) {
                    sb.append((char) (i + 'a'));
                    alpha[i]--;
                }
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
