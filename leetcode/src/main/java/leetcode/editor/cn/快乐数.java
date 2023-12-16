/**
 * @Title: 202.快乐数
 * @TitleSlug: happyNumber
 * @Author: Neo
 * @Date: 2023-12-16 00:58:47
 */
package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class 快乐数 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 快乐数().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Set<Integer> set = new HashSet<>();

        public boolean isHappy(int n) {
            if (n == 1) {
                return true;
            }
            if (!set.add(n)) {
                return false;
            }
            int x = 0;
            while (n > 0) {
                int t = n % 10;
                x += t * t;
                n /= 10;
            }
            return isHappy(x);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       