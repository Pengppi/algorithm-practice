/**
 * @Title: 2646.最小化旅行的价格总和
 * @TitleSlug: minimizeTheTotalPriceOfTheTrips
 * @Author: Neo
 * @Date: 2023-12-06 15:24:37
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 最小化旅行的价格总和 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 最小化旅行的价格总和().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private int[] price, cnt;
        private List<Integer>[] g;

        public int minimumTotalPrice(int n, int[][] edges, int[] price, int[][] trips) {
            g = new List[n];
            Arrays.setAll(g, e -> new ArrayList<>());
            for (int[] e : edges) {
                int x = e[0], y = e[1];
                g[x].add(y);
                g[y].add(x);
            }
            cnt = new int[n];
            this.price = price;
            for (int[] trip : trips) {
                int s = trip[0], e = trip[1];
                dfs(s, -1, e);
            }

            int[] ans = dp(0, -1);
            return Math.min(ans[0], ans[1]);
        }

        private int[] dp(int x, int fa) {
            int val = price[x] * cnt[x];
            int cutVal = val / 2;
            for (Integer y : g[x]) {
                if (y != fa) {
                    int[] res = dp(y, x);
                    val += Math.min(res[0], res[1]);
                    cutVal += res[0];
                }
            }
            return new int[]{val, cutVal};
        }

        private boolean dfs(int x, int fa, int end) {
            if (x == end) {
                cnt[x]++;
                return true;
            }
            for (Integer y : g[x]) {
                if (y != fa && dfs(y, x, end)) {
                    cnt[x]++;
                    return true;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       