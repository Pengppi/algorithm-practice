/**
 * @Title: 1616.分割两个字符串得到回文串
 * @TitleSlug: splitTwoStringsToMakePalindrome
 * @Author: Neo
 * @Date: 2023-03-18 00:04:25
 */
package leetcode.editor.cn;

public class 分割两个字符串得到回文串 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 分割两个字符串得到回文串().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkPalindromeFormation(String a, String b) {
        return check(a, b) || check(b, a);
    }

    public boolean check(String a, String b) {
        int n = a.length();
        int l = 0, r = n - 1;
        while (l < r) {
            if (a.charAt(l) != b.charAt(r)) {
                break;
            }
            l++;
            r--;
        }
        if (l >= r) {
            return true;
        }
        return isPalindrome(a, l, r) || isPalindrome(b, l, r);
    }

    public boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return l >= r;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
}
