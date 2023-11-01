/**
 * @Title: 1017.负二进制转换
 * @TitleSlug: convertToBase2
 * @Author: Neo
 * @Date: 2023-11-01 16:37:11
 */
package leetcode.editor.cn;

public class 负二进制转换 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 负二进制转换().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String baseNeg2(int n) {
            if (n == 0) {
                return "0";
            }
            StringBuilder ans = new StringBuilder();
            while (n != 0) {
                ans.append(n & 1);
                n = -(n >> 1);
            }
            return ans.reverse().toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       