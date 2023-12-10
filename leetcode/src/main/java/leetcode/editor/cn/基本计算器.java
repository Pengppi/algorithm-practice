/**
 * @Title: 224.基本计算器
 * @TitleSlug: basicCalculator
 * @Author: Neo
 * @Date: 2023-12-09 16:49:50
 */
package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class 基本计算器 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 基本计算器().new Solution();
        solution.calculate("1 + 1");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int calculate(String s) {
            Deque<Integer> ops = new ArrayDeque<>();
            Deque<Integer> val = new ArrayDeque<>();
            s = s.replaceAll(" ", "");
            char[] cs = s.toCharArray();
            int ans = 0, sign = 1;
            for (int i = 0; i < cs.length; i++) {
                if (Character.isDigit(cs[i])) {
                    int x = cs[i] - '0', j = i + 1;
                    while (j < cs.length && Character.isDigit(cs[j])) {
                        x = x * 10 + cs[j] - '0';
                        j++;
                    }
                    ans += x * sign;
                    i = j - 1;
                } else if (cs[i] == '+' || cs[i] == '-') {
                    sign = cs[i] == '-' ? -1 : 1;
                } else if (cs[i] == '(') {
                    val.push(ans);
                    ops.push(sign);
                    sign = 1;
                    ans = 0;
                } else {
                    ans = val.pop() + ops.pop() * ans;
                }
            }
            return ans;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       