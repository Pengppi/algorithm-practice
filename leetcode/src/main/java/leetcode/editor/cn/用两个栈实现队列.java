/**
 * @Title: 剑指 Offer 09.用两个栈实现队列
 * @TitleSlug: yongLiangGeZhanShiXianDuiLieLcof
 * @Author: Neo
 * @Date: 2023-04-28 13:12:34
 */
package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class 用两个栈实现队列 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 用两个栈实现队列().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class CQueue {

        Deque<Integer> stack1;
        Deque<Integer> stack2;

        public CQueue() {
            stack1 = new ArrayDeque<>();
            stack2 = new ArrayDeque<>();

        }

        public void appendTail(int value) {
            stack1.push(value);

        }

        public int deleteHead() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            if (stack2.isEmpty()) {
                return -1;
            } else {
                return stack2.pop();
            }
        }
    }

    /**
     * Your CQueue object will be instantiated and called as such:
     * CQueue obj = new CQueue();
     * obj.appendTail(value);
     * int param_2 = obj.deleteHead();
     */
    //leetcode submit region end(Prohibit modification and deletion)

}
        
       