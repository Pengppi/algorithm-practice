/**
 * @Title: 13.罗马数字转整数
 * @TitleSlug: RomanToInteger
 * @Author: Neo
 * @Date: 2022-10-23 13:23:08
 */
package leetcode.editor.cn;

public class 罗马数字转整数 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 罗马数字转整数().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int romanToInt(String s) {
            int n = s.length();
            int[] nums = new int[n + 1];
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == 'I') {
                    nums[i] = 1;
                } else if (c == 'V') {
                    nums[i] = 5;
                } else if (c == 'X') {
                    nums[i] = 10;
                } else if (c == 'L') {
                    nums[i] = 50;
                } else if (c == 'C') {
                    nums[i] = 100;
                } else if (c == 'D') {
                    nums[i] = 500;
                } else if (c == 'M') {
                    nums[i] = 1000;
                }
            }
            int ans = 0;
            for (int i = 0; i < n; i++) {
                if (nums[i] < nums[i + 1]) {
                    ans -= nums[i];
                } else {
                    ans += nums[i];
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
