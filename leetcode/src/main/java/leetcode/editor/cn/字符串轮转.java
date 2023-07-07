/**
 * @Title: 面试题 01.09.字符串轮转
 * @TitleSlug: StringRotationLcci
 * @Author: Neo
 * @Date: 2022-09-29 09:44:17
 */
package leetcode.editor.cn;

public class 字符串轮转 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 字符串轮转().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isFlipedString(String s1, String s2) {
            if (s1.length() != s2.length()) {
                return false;
            }
            return (s1 + s1).contains(s2);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
