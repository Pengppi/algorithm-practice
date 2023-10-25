/**
 * @Title: 2520.统计能整除数字的位数
 * @TitleSlug: countTheDigitsThatDivideANumber
 * @Author: Neo
 * @Date: 2023-10-26 00:06:57
 */
package leetcode.editor.cn;

public class 统计能整除数字的位数 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 统计能整除数字的位数().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countDigits(int num) {
            int ans = 0;
            int t = num;
            while (t > 0) {
                int x = t % 10;
                t /= 10;
                if (num % x == 0) {
                    ans++;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       