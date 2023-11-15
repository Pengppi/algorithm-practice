/**
 * @Title: 399.除法求值
 * @TitleSlug: evaluateDivision
 * @Author: Neo
 * @Date: 2023-11-14 15:38:48
 */
package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 除法求值 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 除法求值().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
            Map<String, Integer> stringToInt = new HashMap<>();
            int n = 0;
            for (List<String> equation : equations) {
                for (String s : equation) {
                    if (!stringToInt.containsKey(s)) {
                        stringToInt.put(s, n++);
                    }
                }
            }
            double[][] g = new double[n][n];
            for (int i = 0; i < equations.size(); i++) {
                List<String> e = equations.get(i);
                int a = stringToInt.get(e.get(0)), b = stringToInt.get(e.get(1));
                g[a][b] = values[i];
                g[b][a] = 1 / values[i];
            }
            int len = queries.size();
            double[] ans = new double[len];
            Arrays.fill(ans, -1.0);
            for (int i = 0; i < len; i++) {
                List<String> q = queries.get(i);
                if (!stringToInt.containsKey(q.get(0)) || !stringToInt.containsKey(q.get(1))) {
                    continue;
                }
                int a = stringToInt.get(q.get(0)), b = stringToInt.get(q.get(1));
                if (g[a][b] == 0 && dfs(g, a, b, new boolean[n]) == 0) {
                    continue;
                }
                ans[i] = g[a][b];
            }
            return ans;
        }

        private double dfs(double[][] g, int a, int b, boolean[] isVisted) {
            if (g[a][b] != 0) {
                return g[a][b];
            }
            isVisted[a] = true;
            int n = g.length;
            double res = 0;
            for (int i = 0; i < n; i++) {
                if (isVisted[i] || g[a][i] == 0) {
                    continue;
                }
                res = g[a][i];
                res *= dfs(g, i, b, isVisted);
                if (res != 0) {
                    return g[a][b] = res;
                }
            }
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       