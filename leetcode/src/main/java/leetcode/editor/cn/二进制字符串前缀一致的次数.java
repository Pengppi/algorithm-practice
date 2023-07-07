/**
 * @Title: 1375.二进制字符串前缀一致的次数
 * @TitleSlug: numberOfTimesBinaryStringIsPrefixAligned
 * @Author: Neo
 * @Date: 2023-06-14 14:37:35
 */
package leetcode.editor.cn;

public class 二进制字符串前缀一致的次数 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 二进制字符串前缀一致的次数().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numTimesAllBlue(int[] flips) {
            int right = 0;
            int res = 0;
            for (int i = 0; i < flips.length; i++) {
                right = Math.max(right, flips[i]);
                if (right == i + 1) {
                    res++;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       