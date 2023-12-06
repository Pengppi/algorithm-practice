/**
 * @Title: 134.加油站
 * @TitleSlug: gasStation
 * @Author: Neo
 * @Date: 2023-12-05 15:04:22
 */
package leetcode.editor.cn;

public class 加油站 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 加油站().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int canCompleteCircuit(int[] gas, int[] cost) {
            int n = gas.length;
            int[] tmp = new int[n];
            for (int i = 0; i < n; i++) {
                tmp[i] = gas[i] - cost[i];
            }
            int i = 0;
            while (i < n) {
                int cnt = 0, sum = 0;
                while (cnt < n) {
                    int j = (i + cnt) % n;
                    sum += tmp[j];
                    if (sum < 0) {
                        break;
                    }
                    cnt++;
                }
                if (cnt == n) {
                    return i;
                }
                i += cnt + 1;
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       