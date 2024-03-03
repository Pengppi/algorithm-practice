/**
 * @Title: 225.用队列实现栈
 * @TitleSlug: implementStackUsingQueues
 * @Author: Neo
 * @Date: 2024-03-03 10:47:24
 */
package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class 用队列实现栈implementStackUsingQueues {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 用队列实现栈implementStackUsingQueues().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class MyStack {
        Deque<Integer> q1;
        Deque<Integer> q2;
        
        public MyStack() {
            q1 = new ArrayDeque<>();
            q2 = new ArrayDeque<>();
        }
        
        public void push(int x) {
            q1.offer(x);
            while (!q2.isEmpty()) {
                q1.offer(q2.poll());
            }
            Deque<Integer> temp = q1;
            q1 = q2;
            q2 = temp;
        }
        
        public int pop() {
            return q2.poll();
        }
        
        public int top() {
            return q2.peek();
        }
        
        public boolean empty() {
            return q2.isEmpty();
        }
    }

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
// leetcode submit region end(Prohibit modification and deletion)

}
       