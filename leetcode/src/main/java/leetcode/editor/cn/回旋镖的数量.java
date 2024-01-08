/**
 * @Title: 447.回旋镖的数量
 * @TitleSlug: numberOfBoomerangs
 * @Author: Neo
 * @Date: 2024-01-08 08:59:40
 */
package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class 回旋镖的数量 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 回旋镖的数量().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numberOfBoomerangs(int[][] points) {
            int n = points.length, ans = 0;
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < n - 1; i++) {
                int x1 = points[i][0], y1 = points[i][1];
                for (int j = i + 1; j < n; j++) {
                    int x2 = points[j][0], y2 = points[j][1];
                    int dist = getDistance(x1, y1, x2, y2);
                    String key1 = i + "-" + dist;
                    String key2 = j + "-" + dist;
                    ans += map.getOrDefault(key1, 0);
                    ans += map.getOrDefault(key2, 0);
                    map.put(key1, map.getOrDefault(key1, 0) + 1);
                    map.put(key2, map.getOrDefault(key2, 0) + 1);
                }
            }
            return ans * 2;
        }

        private int getDistance(int x1, int y1, int x2, int y2) {
            int res = (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       