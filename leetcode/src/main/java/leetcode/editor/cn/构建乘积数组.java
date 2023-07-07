/**
 * @Title: 剑指 Offer 66.构建乘积数组
 * @TitleSlug: gouJianChengJiShuZuLcof
 * @Author: Neo
 * @Date: 2023-05-18 14:10:00
 */
package leetcode.editor.cn;

public class 构建乘积数组 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 构建乘积数组().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] constructArr(int[] a) {
            int n = a.length;
            if (n == 0) {
                return new int[0];
            }
            int[] b = new int[n];
            int cur = a[0];
            b[0] = 1;
            for (int i = 1; i < n; i++) {
                b[i] = cur;
                cur *= a[i];
            }
            cur = a[n - 1];
            for (int i = n - 2; i >= 0; i--) {
                b[i] *= cur;
                cur *= a[i];
            }
            return b;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       