/**
 * @Title: 1053.交换一次的先前排列
 * @TitleSlug: previousPermutationWithOneSwap
 * @Author: Neo
 * @Date: 2023-04-03 09:58:07
 */
package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class 交换一次的先前排列 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 交换一次的先前排列().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] prevPermOpt1(int[] arr) {
            int n = arr.length;
            Deque<Integer> d = new ArrayDeque<>();
            for (int i = n - 2; i >= 0; i--) {
                int t = arr[i];
                int mx = -1;
                for (int j = i + 1; j < n; j++) {
                    if (arr[j] < t) {
                        if (mx == -1 || arr[j] > arr[mx]) {
                            mx = j;
                        }
                    }
                }
                if (mx != -1) {
                    arr[i] = arr[mx];
                    arr[mx] = t;
                    break;
                }
            }
            return arr;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}
