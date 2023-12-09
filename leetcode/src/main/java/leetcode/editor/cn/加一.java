/**
 * @Title: 66.加一
 * @TitleSlug: plusOne
 * @Author: Neo
 * @Date: 2023-12-08 00:38:14
 */
package leetcode.editor.cn;

public class 加一 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 加一().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] plusOne(int[] digits) {
            int i = digits.length - 1;
            int cnt = 1;
            while (i >= 0 && cnt > 0) {
                int x = digits[i] + cnt;
                digits[i] = x % 10;
                cnt = x / 10;
                i--;
            }
            if (cnt > 0) {
                int[] arr = new int[digits.length + 1];
                arr[0] = cnt;
                for (int j = 1; j < arr.length; j++) {
                    arr[j] = digits[j - 1];
                }
                return arr;
            }
            return digits;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       