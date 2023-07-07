/**
 * @Title: 904.水果成篮
 * @TitleSlug: FruitIntoBaskets
 * @Author: Neo
 * @Date: 2022-10-17 14:11:01
 */
package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class 水果成篮 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 水果成篮().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int totalFruit(int[] fruits) {
            Deque<Integer> d = new ArrayDeque<>();
            int ans = 0;
            int l = 0, r = 0;
            while (r < fruits.length) {
                if (!d.contains(fruits[r])) {
                    d.addLast(fruits[r]);
                }else{
                    d.remove(fruits[r]);
                    d.addLast(fruits[r]);
                }
                if (d.size() > 2) {
                    ans = Math.max(ans, r - l);
                    int f = d.pollFirst();
                    l = r;
                    while (fruits[l - 1] != f) {
                        l--;
                    }
                }
                r++;
            }
            return Math.max(ans, r - l);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
