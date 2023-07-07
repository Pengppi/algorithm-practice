/**
 * @Title: 剑指 Offer 15.二进制中1的个数
 * @TitleSlug: erJinZhiZhong1deGeShuLcof
 * @Author: Neo
 * @Date: 2023-04-30 14:48:57
 */
package leetcode.editor.cn;

public class 二进制中1的个数 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 二进制中1的个数().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    public class Solution {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            int cnt = 0;
            while (n != 0) {
                cnt ++;
                n = n & (n - 1);
            }
            return cnt;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
        
       