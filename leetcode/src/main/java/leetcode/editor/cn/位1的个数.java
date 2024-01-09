/**
 * @Title: 191.位1的个数
 * @TitleSlug: numberOf1Bits
 * @Author: Neo
 * @Date: 2024-01-09 13:59:22
 */
package leetcode.editor.cn;

public class 位1的个数 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 位1的个数().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    public class Solution {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            int ans = 0;
            for (int i = 0; i < 32; i++) {
                if ((n & (1 << i)) != 0) {
                    ans++;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       