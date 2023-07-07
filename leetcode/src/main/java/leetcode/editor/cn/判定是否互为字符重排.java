/**
 * @Title: 面试题 01.02.判定是否互为字符重排
 * @Author: Neo
 * @Date: 2022-09-27 09:31:48
 */
package leetcode.editor.cn;

public class 判定是否互为字符重排 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 判定是否互为字符重排().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean CheckPermutation(String s1, String s2) {
            if (s1.length() != s2.length()) {
                return false;
            }
            int[] chars = new int[128];
            for (int i = 0; i < s1.length(); i++) {
                chars[s1.charAt(i)]++;
                chars[s2.charAt(i)]--;
            }
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] != 0) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
