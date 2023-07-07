/**
 * @Title: 769.最多能完成排序的块
 * @TitleSlug: MaxChunksToMakeSorted
 * @Author: Neo
 * @Date: 2022-10-13 14:23:39
 */
package leetcode.editor.cn;

public class 最多能完成排序的块 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 最多能完成排序的块().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxChunksToSorted(int[] arr) {
            int n = arr.length;
            int ans = 0;
            for (int i = 0, j = 0, min = n, max = -1; i < n; i++) {
                min = Math.min(min, arr[i]);
                max = Math.max(max, arr[i]);
                if (min == j && max == i) {
                    ans++;
                    j = i + 1;
                    min = n;
                    max = -1;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
