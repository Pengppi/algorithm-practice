/**
 * @Title: 1620.网络信号最好的坐标
 * @TitleSlug: CoordinateWithMaximumNetworkQuality
 * @Author: Neo
 * @Date: 2022-11-02 21:47:34
 */
package leetcode.editor.cn;

public class 网络信号最好的坐标 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 网络信号最好的坐标().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] bestCoordinate(int[][] towers, int radius) {
            int xmin = 0, xmax = 0, ymin = 0, ymax = 0;
            for (int[] t : towers) {
                xmin = Math.min(xmin, t[0]);
                xmax = Math.max(xmax, t[0]);
                ymin = Math.min(ymin, t[1]);
                ymax = Math.max(ymax, t[1]);
            }
            int sc = 0;
            int ans[] = new int[2];
            ans[0] = 0;
            ans[1] = 0;
            int r = radius * radius;
            for (int x = Math.max(xmin - radius, 0); x <= xmax + radius; x++) {
                for (int y = Math.max(ymin - radius, 0); y <= ymax + radius; y++) {
                    int sum = 0;
                    for (int[] t : towers) {
                        int dist = (x - t[0]) * (x - t[0]) + (y - t[1]) * (y - t[1]);
                        if (dist <= r) {
                            sum += (int) t[2] / (1 + Math.sqrt(dist));
                        }
                    }
                    if (sum > sc) {
                        sc = sum;
                        ans[0] = x;
                        ans[1] = y;
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
