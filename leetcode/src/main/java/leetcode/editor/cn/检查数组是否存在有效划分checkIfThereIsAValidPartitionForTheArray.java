/**
 * @Title: 2369.检查数组是否存在有效划分
 * @TitleSlug: checkIfThereIsAValidPartitionForTheArray
 * @Author: Neo
 * @Date: 2024-03-01 17:44:12
 */
package leetcode.editor.cn;

public class 检查数组是否存在有效划分checkIfThereIsAValidPartitionForTheArray {
    public static void main(String[] args) {
        // 测试代码
        Solution solution = new 检查数组是否存在有效划分checkIfThereIsAValidPartitionForTheArray().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean validPartition(int[] nums) {
            int n = nums.length;
            boolean[] f = new boolean[n + 1];
            f[0] = true;
            f[2] = nums[1] == nums[0];
            for (int i = 2; i < n; i++) {
                if (nums[i] == nums[i - 1]) {
                    f[i + 1] = f[i - 1];
                }
                if (nums[i] == nums[i - 1] && nums[i - 1] == nums[i - 2]) {
                    f[i + 1] |= f[i - 2];
                } else if (nums[i] - 1 == nums[i - 1] && nums[i - 1] - 1 == nums[i - 2]) {
                    f[i + 1] |= f[i - 2];
                }
            }
            return f[n];
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       