/**
 * @Title: 155.最小栈
 * @TitleSlug: minStack
 * @Author: Neo
 * @Date: 2023-12-03 12:57:53
 */
package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class 最小栈 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 最小栈().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MinStack {

        Deque<Integer> st;
        Deque<Integer> mn;

        public MinStack() {
            st = new ArrayDeque<>();
            mn = new ArrayDeque<>();
        }

        public void push(int val) {
            st.push(val);
            if (mn.isEmpty()||val <= mn.peek()) {
                mn.push(val);
            }
        }

        public void pop() {
            int x = st.pop();
            if (x == mn.peek()) {
                mn.pop();
            }
        }

        public int top() {
            return st.peek();
        }

        public int getMin() {
            return mn.peek();
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
        
       