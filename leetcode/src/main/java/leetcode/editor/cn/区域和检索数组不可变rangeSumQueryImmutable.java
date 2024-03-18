/**
 * @Title: 303.区域和检索 - 数组不可变
 * @TitleSlug: rangeSumQueryImmutable
 * @Author: Neo
 * @Date: 2024-03-18 00:51:45
 */
package leetcode.editor.cn;

public class 区域和检索数组不可变rangeSumQueryImmutable {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 区域和检索数组不可变rangeSumQueryImmutable().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class NumArray {
        
        int[] sum;
        
        public NumArray(int[] nums) {
            int n = nums.length;
            sum = new int[n + 1];
            for (int i = 0; i < n; i++) {
                sum[i + 1] = sum[i] + nums[i];
            }
        }
        
        public int sumRange(int left, int right) {
            return sum[right + 1] - sum[left];
        }
    }

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
// leetcode submit region end(Prohibit modification and deletion)

}
       