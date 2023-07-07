/**
 * @Title: 剑指 Offer 57 - II.和为s的连续正数序列
 * @TitleSlug: heWeiSdeLianXuZhengShuXuLieLcof
 * @Author: Neo
 * @Date: 2023-05-19 15:51:04
 */
package leetcode.editor.cn;

import java.util.ArrayList;

public class 和为s的连续正数序列 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 和为s的连续正数序列().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] findContinuousSequence(int target) {
            List<List<Integer>> lists = new ArrayList<>();
            int len = 1, cur = 1;
            while (cur <= target) {
                len++;
                cur = len * (len + 1) / 2;
            }
            len--;
            while (len >= 2) {
                int f = getFirstByLen(target, len);
                if (f != -1) {
                    List<Integer> list = new ArrayList<>();
                    list.add(f);
                    list.add(len);
                    lists.add(list);
                }
                len--;
            }
            int n = lists.size();
            int[][] ans = new int[n][n];
            for (int i = 0; i < n; i++) {
                List<Integer> list = lists.get(i);
                int s = list.get(0);
                int l = list.get(1);
                ans[i] = new int[l];
                for (int j = s, k = 0; j < s + l; j++, k++) {
                    ans[i][k] = j;
                }
            }
            return ans;
        }

        int getFirstByLen(int t, int len) {
            if (2 * t % len != 0) {
                return -1;
            }
            int res = 2 * t / len - len + 1;
            if (res % 2 != 0) {
                return -1;
            }
            return res / 2;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       