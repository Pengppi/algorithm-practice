/**
 * @Title: 365.水壶问题
 * @TitleSlug: WaterAndJugProblem
 * @Author: Neo
 * @Date: 2022-11-01 14:36:16
 */
package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class 水壶问题 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 水壶问题().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
            Deque<int[]> d = new ArrayDeque<>();
            Set<Long> seen = new HashSet<>();
            d.addLast(new int[]{0, 0});
            while (!d.isEmpty()) {
                int t[] = d.pollFirst();
                if (seen.add(hash(t))) {
                    int x = t[0], y = t[1];
                    if (x == targetCapacity || y == targetCapacity || x + y == targetCapacity) {
                        return true;
                    }
                    d.addLast(new int[]{x, 0});
                    d.addLast(new int[]{0, y});
                    d.addLast(new int[]{x, jug2Capacity});
                    d.addLast(new int[]{jug1Capacity, y});
                    d.addLast(new int[]{x - Math.min(x, jug2Capacity - y), y + Math.min(x, jug2Capacity - y)});
                    d.addLast(new int[]{x + Math.min(y, jug1Capacity - x), y - Math.min(y, jug1Capacity - x)});
                }
            }
            return false;
        }

        private Long hash(int[] t) {
            return (long) t[0] * 1000005 + t[1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
