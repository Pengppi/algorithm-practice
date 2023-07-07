/**
 * @Title: 1043.分隔数组以得到最大和
 * @TitleSlug: partitionArrayForMaximumSum
 * @Author: Neo
 * @Date: 2023-04-19 13:52:55
 */
package leetcode.editor.cn;

public class 分隔数组以得到最大和 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 分隔数组以得到最大和().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSumAfterPartitioning(int[] arr, int k) {
            int n = arr.length;
            int[] f = new int[n];
            for (int i = 0; i < n; i++) {
                for (int j = i, mx = 0; j >= Math.max(i - k + 1, 0); j--) {
                    mx = Math.max(mx, arr[j]);
                    f[i] = Math.max(f[i], (j >= 1 ? f[j - 1] : 0) + (i - j + 1) * mx);
                }
            }
            return f[n - 1];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
        
       