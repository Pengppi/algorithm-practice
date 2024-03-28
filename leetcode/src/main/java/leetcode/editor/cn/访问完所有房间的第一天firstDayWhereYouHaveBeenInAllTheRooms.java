/**
 * @Title: 1997.访问完所有房间的第一天
 * @TitleSlug: firstDayWhereYouHaveBeenInAllTheRooms
 * @Author: Neo
 * @Date: 2024-03-28 11:57:43
 */
package leetcode.editor.cn;

public class 访问完所有房间的第一天firstDayWhereYouHaveBeenInAllTheRooms {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 访问完所有房间的第一天firstDayWhereYouHaveBeenInAllTheRooms().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int firstDayBeenInAllRooms(int[] nextVisit) {
            final int mod = 1000000007;
            int n = nextVisit.length;
            long[] sum = new long[n];
            for (int i = 0; i < n - 1; i++) {
                int j = nextVisit[i];
                sum[i + 1] = ((sum[i] * 2 + 2 - sum[j]) + mod) % mod;
            }
            return (int) sum[n - 1];
        }
    }
// leetcode submit region end(Prohibit modification and deletion)
    
}
       