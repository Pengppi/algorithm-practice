/**
 * @Title: 1668.最大重复子字符串
 * @TitleSlug: MaximumRepeatingSubstring
 * @Author: Neo
 * @Date: 2022-11-03 00:11:22
 */
package leetcode.editor.cn;

public class 最大重复子字符串 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 最大重复子字符串().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxRepeating(String sequence, String word) {
            int cnt = 0;
            String s = word;
            while (sequence.contains(s)) {
                cnt++;
                s += word;
            }
            return cnt;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
