/**
 * @Title: 125.验证回文串
 * @TitleSlug: validPalindrome
 * @Author: Neo
 * @Date: 2024-04-29 15:26:57
 */
package leetcode.editor.cn;

public class 验证回文串validPalindrome {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 验证回文串validPalindrome().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(String s) {
            int[] arr = s.chars().filter(Character::isLetterOrDigit).map(Character::toLowerCase).toArray();
            int l = 0, r = arr.length - 1;
            while (l < r) {
                if (arr[l++] != arr[r--]) {
                    return false;
                }
            }
            return true;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       