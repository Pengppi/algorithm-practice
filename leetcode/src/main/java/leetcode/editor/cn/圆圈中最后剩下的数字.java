/**
 * @Title: 剑指 Offer 62.圆圈中最后剩下的数字
 * @TitleSlug: yuanQuanZhongZuiHouShengXiaDeShuZiLcof
 * @Author: Neo
 * @Date: 2023-05-19 15:51:09
 */
package leetcode.editor.cn;

import java.util.LinkedList;

public class 圆圈中最后剩下的数字 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 圆圈中最后剩下的数字().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lastRemaining(int n, int m) {
            int idx = 0;
            for (int i = 2; i <= n; i++) {
                idx = (idx + m) % i;
            }
            return idx;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       