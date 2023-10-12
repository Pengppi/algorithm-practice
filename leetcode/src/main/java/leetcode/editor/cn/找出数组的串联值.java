/**
 * @Title: 2562.找出数组的串联值
 * @TitleSlug: findTheArrayConcatenationValue
 * @Author: Neo
 * @Date: 2023-10-12 00:41:39
 */
package leetcode.editor.cn;

public class 找出数组的串联值 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 找出数组的串联值().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long findTheArrayConcVal(int[] nums) {
            int n = nums.length;
            int l = 0, r = n - 1;
            long ans = 0;
            while (l <= r) {
                if (l == r) {
                    ans += nums[l];
                    break;
                } else {
                    ans += concat(nums[l++], nums[r--]);
                }
            }
            return ans;
        }

        private long concat(int a, int b) {
            int x = b;
            while (x > 0) {
                x /= 10;
                a *= 10;
            }
            return a + b;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       