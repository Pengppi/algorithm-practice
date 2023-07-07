/**
 * @Title: 2106.摘水果
 * @TitleSlug: maximumFruitsHarvestedAfterAtMostKSteps
 * @Author: Neo
 * @Date: 2023-05-04 11:27:31
 */
package leetcode.editor.cn;

public class 摘水果 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 摘水果().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxTotalFruits(int[][] fruits, int startPos, int k) {
            int l = lower_bound(fruits, startPos - k);
            int sum = 0, r = l, n = fruits.length;
            for (; r < n && fruits[r][0] <= startPos; r++) {
                sum += fruits[r][1];
            }
            int ans = sum;
            for (; r < n && fruits[r][0] <= startPos + k; r++) {
                sum += fruits[r][1];
                while (fruits[r][0] * 2 - fruits[l][0] - startPos > k &&
                        fruits[r][0] - fruits[l][0] * 2 + startPos > k) {
                    sum -= fruits[l++][1];
                }
                ans = Math.max(ans, sum);
            }
            return ans;

        }


        public int lower_bound(int[][] arr, int target) {
            int l = -1, r = arr.length;
            while (l + 1 < r) {
                int mid=(l+r)/2;
                if (arr[mid][0] < target) {
                    l = mid;
                } else {
                    r = mid;
                }
            }
            return r;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
        
       