/**
 * @Title: 1784.检查二进制字符串字段
 * @TitleSlug: CheckIfBinaryStringHasAtMostOneSegmentOfOnes
 * @Author: Neo
 * @Date: 2022-10-29 13:36:03
 */
package leetcode.editor.cn;

public class 检查二进制字符串字段 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 检查二进制字符串字段().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkOnesSegment(String s) {
            int cnt = 0;
            char[] cs = s.toCharArray();
            for (int i = 0; i < cs.length; i++) {
                if (cs[i] == '1') {
                    cnt++;
                    while (i < cs.length && cs[i] == '1') {
                        i++;
                    }
                }
            }
            return cnt <= 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
