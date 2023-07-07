/**
 * @Title: 970.强整数
 * @TitleSlug: powerfulIntegers
 * @Author: Neo
 * @Date: 2023-05-02 14:05:39
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;

public class 强整数 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 强整数().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> powerfulIntegers(int x, int y, int bound) {
            Set<Integer> set = new HashSet<>();
            for (int a = 1; a < bound; a *= x) {
                for (int b = 1; a + b <= bound; b *= y) {
                    set.add(a + b);
                    if (y == 1) {
                        break;
                    }
                }
                if (x == 1) {
                    break;
                }
            }

            return new ArrayList<>(set);
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}
        
       