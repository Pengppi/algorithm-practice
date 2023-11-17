/**
 * @Title: 2736.最大和查询
 * @TitleSlug: maximumSumQueries
 * @Author: Neo
 * @Date: 2023-11-17 09:46:33
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 最大和查询 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 最大和查询().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] maximumSumQueries(int[] nums1, int[] nums2, int[][] queries) {
            int n = nums1.length;
            int[][] arr = new int[n][2];
            for (int i = 0; i < n; i++) {
                arr[i][0] = nums1[i];
                arr[i][1] = nums2[i];
            }
            Arrays.sort(arr, (a, b) -> (b[0] - a[0]));
            Integer[] qid = new Integer[queries.length];
            for (int i = 0; i < qid.length; i++) {
                qid[i] = i;
            }
            Arrays.sort(qid, (a, b) -> (queries[b][0] - queries[a][0]));
            int[] ans = new int[queries.length];
            List<int[]> stack = new ArrayList<>();
            int j = 0;
            for (Integer i : qid) {
                int x = queries[i][0], y = queries[i][1];
                for (; j < n && arr[j][0] >= x; j++) {
                    int sum = arr[j][0] + arr[j][1];
                    while (stack.size() > 0 && stack.get(stack.size() - 1)[1] <= sum) {
                        stack.remove(stack.size() - 1);
                    }
                    if (stack.isEmpty() || stack.get(stack.size() - 1)[0] < arr[j][1]) {
                        stack.add(new int[]{arr[j][1], sum});
                    }
                }
                int p = lower_bound(stack, y);
                ans[i] = p < stack.size() ? stack.get(p)[1] : -1;
            }
            return ans;
        }

        private int lower_bound(List<int[]> stack, int t) {
            int l = 0, r = stack.size() - 1;
            while (l <= r) {
                int m = l + (r - l) / 2;
                if (stack.get(m)[0] < t) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
            return l;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       