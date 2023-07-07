/**
 * @Title: 剑指 Offer 51.数组中的逆序对
 * @TitleSlug: shuZuZhongDeNiXuDuiLcof
 * @Author: Neo
 * @Date: 2023-05-15 16:58:18
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class 数组中的逆序对 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 数组中的逆序对().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int ans = 0;
        int[] aux;

        public int reversePairs(int[] nums) {
            int n = nums.length;
            if (n < 2) {
                return 0;
            }
            aux = new int[n];
            sort(nums, 0, n - 1);
            return ans;
        }

        private void sort(int[] nums, int l, int r) {
            if (r <= l) {
                return;
            }
            int m = l + (r - l) / 2;
            sort(nums, l, m);
            sort(nums, m + 1, r);
            merge(nums, l, m, r);
        }

        private void merge(int[] nums, int l, int m, int r) {
            int i = l, j = m + 1;
            for (int k = l; k <= r; k++) {
                aux[k] = nums[k];
            }
            for (int k = l; k <= r; k++) {
                if (i > m) {
                    nums[k] = aux[j++];
                } else if (j > r) {
                    nums[k] = aux[i++];
                } else if (aux[j] < aux[i]) {
                    nums[k] = aux[j++];
                    ans += m - i + 1;
                } else {
                    nums[k] = aux[i++];
                }
            }
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}
        
       