/**
 * @Title: 2240.买钢笔和铅笔的方案数
 * @TitleSlug: numberOfWaysToBuyPensAndPencils
 * @Author: Neo
 * @Date: 2023-09-01 14:45:08
 */
package leetcode.editor.cn;

public class 买钢笔和铅笔的方案数 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 买钢笔和铅笔的方案数().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long waysToBuyPensPencils(int total, int cost1, int cost2) {
            long ans = 0;
            for (int i = 0; i * cost1 <= total; i++) {
                int left = total - cost1 * i;
                ans += left / cost2 + 1;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       