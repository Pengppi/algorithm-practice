/**
 * @Title: 135.分发糖果
 * @TitleSlug: Candy
 * @Author: Neo
 * @Date: 2022-11-03 00:16:00
 */
package leetcode.editor.cn;

import java.util.Arrays;

public class 分发糖果 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 分发糖果().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int candy(int[] ratings) {
            int n = ratings.length;
            int arr[] = new int[n];
            Arrays.fill(arr, 1);
            for (int i = 1; i < n; i++) {
                if (ratings[i] > ratings[i - 1]) {
                    arr[i] = arr[i - 1] + 1;
                }
            }
            int sum = arr[n - 1];
            for (int i = n - 2; i >= 0; i--) {
                if (ratings[i] > ratings[i + 1]) {
                    arr[i] = Math.max(arr[i], arr[i + 1] + 1);
                }
                sum += arr[i];
            }
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
