/**
 * @Title: 724.寻找数组的中心下标
 * @TitleSlug: findPivotIndex
 * @Author: Neo
 * @Date: 2023-10-16 23:34:36
 */
package leetcode.editor.cn;

public class 寻找数组的中心下标 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 寻找数组的中心下标().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int pivotIndex(int[] nums) {
            int n = nums.length;
            int[] l = new int[n];
            int[] r = new int[n];
            for (int i = n - 2; i >= 0; i--) {
                r[i] = r[i + 1] + nums[i + 1];
            }
            if (l[0] == r[0]) {
                return 0;
            }
            for (int i = 1; i < n; i++) {
                l[i] = l[i - 1] + nums[i - 1];
                if (l[i] == r[i]) {
                    return i;
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       