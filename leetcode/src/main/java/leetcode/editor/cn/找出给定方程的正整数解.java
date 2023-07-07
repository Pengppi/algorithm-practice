/**
 * @Title: 1237.找出给定方程的正整数解
 * @TitleSlug: FindPositiveIntegerSolutionForAGivenEquation
 * @Author: Neo
 * @Date: 2023-02-18 10:32:52
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class 找出给定方程的正整数解 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 找出给定方程的正整数解().new Solution();
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    /*
     * // This is the custom function interface.
     * // You should not implement it, or speculate about its implementation
     * class CustomFunction {
     *     // Returns f(x, y) for any given positive integers x and y.
     *     // Note that f(x, y) is increasing with respect to both x and y.
     *     // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
     *     public int f(int x, int y);
     * };
     */

    class Solution {
        public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
            List<List<Integer>> res = new ArrayList<>();
            for (int x = 1, y = 1000; x <= 1000 && y >= 1; x++) {
                while (y >= 1 && customfunction.f(x, y) > z) {
                    y--;
                }
                if (y >= 1 && customfunction.f(x, y) == z) {
                    List<Integer> list = new ArrayList<>();
                    list.add(x);
                    list.add(y);
                    res.add(list);
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
