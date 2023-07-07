/**
 * @Title: 1106.解析布尔表达式
 * @TitleSlug: ParsingABooleanExpression
 * @Author: Neo
 * @Date: 2022-11-05 19:12:52
 */
package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class 解析布尔表达式 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 解析布尔表达式().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean parseBoolExpr(String expression) {
            Deque<Character> num = new ArrayDeque<>();
            Deque<Character> op = new ArrayDeque<>();
            for (char c : expression.toCharArray()) {
                if (c == ',') {
                    continue;
                }
                if (c == '!' || c == '|' || c == '&') {
                    op.push(c);
                }
                if (c == 't' || c == 'f' || c == '(') {
                    num.push(c);
                }
                if (c == ')') {
                    int t = 0, f = 0;
                    while (num.peek() != '(') {
                        if (num.poll() == 't') {
                            t++;
                        } else {
                            f++;
                        }
                    }
                    num.poll();
                    char o = op.poll();
                    if (o == '!') {
                        num.push(f == 1 ? 't' : 'f');
                    } else if (o == '&') {
                        num.push(f == 0 ? 't' : 'f');
                    } else if (o == '|') {
                        num.push(t > 0 ? 't' : 'f');
                    }
                }
            }
                return num.peek() == 't';
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
