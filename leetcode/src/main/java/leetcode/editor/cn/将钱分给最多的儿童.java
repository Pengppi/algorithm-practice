/**
 * @Title: 2591.将钱分给最多的儿童
 * @TitleSlug: distributeMoneyToMaximumChildren
 * @Author: Neo
 * @Date: 2023-09-22 22:54:41
 */
package leetcode.editor.cn;

public class 将钱分给最多的儿童 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 将钱分给最多的儿童().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int distMoney(int money, int children) {
            if (money < children) {
                return -1;
            }
            money -= children;
            int cnt = Math.min(money / 7, children);
            money -= cnt * 7;
            children -= cnt;
            if ((children == 0 && money > 0) || (children == 1 && money == 3)) {
                cnt--;
            }
            return cnt;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       