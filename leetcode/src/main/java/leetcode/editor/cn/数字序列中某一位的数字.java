/**
 * @Title: 剑指 Offer 44.数字序列中某一位的数字
 * @TitleSlug: shuZiXuLieZhongMouYiWeiDeShuZiLcof
 * @Author: Neo
 * @Date: 2023-05-28 14:19:56
 */
package leetcode.editor.cn;

public class 数字序列中某一位的数字 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 数字序列中某一位的数字().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private long getCntByLen(int len) {
            return (long) (Math.pow(10, len) - Math.pow(10, len - 1)) * len;
        }

        public int findNthDigit(int n) {
            int len = 1;
            long sum = getCntByLen(len);
            while (n >= sum) {
                n -= sum;
                sum = getCntByLen(++len);
            }
            long start = (long) Math.pow(10, len - 1);
            start += n / len;
            n -= n / len * len;
            if (n == 0) {
                return (int) (start - 1) % 10;
            }
            return String.valueOf(start).toCharArray()[n - 1] - '0';
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       