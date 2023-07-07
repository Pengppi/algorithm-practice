/**
 * @Title: 9.回文数
 * @TitleSlug: PalindromeNumber
 * @Author: Neo
 * @Date: 2022-10-22 12:36:06
 */
package leetcode.editor.cn;

public class 回文数 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 回文数().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(int x) {
            if (x < 0 || (x % 10 == 0 && x != 0)) {
                return false;
            }
            int revertedNum = 0;
            while (x > revertedNum) {
                revertedNum = revertedNum * 10 + x % 10;
                x /= 10;
            }
            return x == revertedNum || x == revertedNum / 10;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
