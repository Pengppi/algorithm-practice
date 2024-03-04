/**
 * @Title: 232.用栈实现队列
 * @TitleSlug: implementQueueUsingStacks
 * @Author: Neo
 * @Date: 2024-03-04 13:05:17
 */
package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class 用栈实现队列implementQueueUsingStacks {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 用栈实现队列implementQueueUsingStacks().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class MyQueue {
        
        Deque<Integer> st1 = new ArrayDeque<>();
        Deque<Integer> st2 = new ArrayDeque<>();
        
        public MyQueue() {
        }
        
        public void push(int x) {
            while (!st1.isEmpty()) {
                st2.push(st1.pop());
            }
            st1.push(x);
            while (!st2.isEmpty()) {
                st1.push(st2.pop());
            }
        }
        
        public int pop() {
            return st1.pop();
        }
        
        public int peek() {
            return st1.peek();
        }
        
        public boolean empty() {
            return st1.isEmpty();
        }
    }

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
// leetcode submit region end(Prohibit modification and deletion)

}
       