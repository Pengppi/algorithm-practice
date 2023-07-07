/**
 * @Title: 754.到达终点数字
 * @TitleSlug: ReachANumber
 * @Author: Neo
 * @Date: 2022-11-04 11:23:15
 */
package leetcode.editor.cn;

public class 到达终点数字 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 到达终点数字().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int reachNumber(int target) {
            target = Math.abs(target);
            int k = 0;
            while (target > 0) {
                k++;
                target -= k;
            }
            return target % 2 == 0 ? k : k + 1 + k % 2;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
