/**
 * @Title: 剑指 Offer 30.包含min函数的栈
 * @TitleSlug: baoHanMinhanShuDeZhanLcof
 * @Author: Neo
 * @Date: 2023-06-11 15:42:29
 */
package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class 包含min函数的栈 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 包含min函数的栈().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MinStack {
        Deque<int[]> stack;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            stack = new ArrayDeque<>();
        }

        public void push(int x) {
            if (stack.isEmpty()) {
                stack.push(new int[]{x, x});
            } else {
                int min = Math.min(x, stack.peek()[1]);
                stack.push(new int[]{x, min});
            }
        }

        public void pop() {
            stack.pop();
        }

        public int top() {
            return stack.peek()[0];
        }

        public int min() {
            return stack.peek()[1];
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
        
       