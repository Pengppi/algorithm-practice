/**
 * @Title: 1630.等差子数组
 * @TitleSlug: arithmeticSubarrays
 * @Author: Neo
 * @Date: 2023-03-23 14:56:04
 */
package leetcode.editor.cn;

public class 等差子数组 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 等差子数组().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
            int n = nums.length, m = l.length;
            List<Boolean> ans = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                int[] arr = Arrays.copyOfRange(nums, l[i], r[i] + 1);
                Arrays.sort(arr);
                int d = arr[1] - arr[0];
                boolean flag = true;
                for (int j = 2; j < arr.length; j++) {
                    if (arr[j] - arr[j - 1] != d) {
                        flag = false;
                        break;
                    }
                }
                ans.add(flag);
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}
