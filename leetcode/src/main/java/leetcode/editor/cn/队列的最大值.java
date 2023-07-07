/**
 * @Title: 剑指 Offer 59 - II.队列的最大值
 * @TitleSlug: duiLieDeZuiDaZhiLcof
 * @Author: Neo
 * @Date: 2023-06-10 15:04:36
 */
package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class 队列的最大值 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 队列的最大值().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MaxQueue {

        Deque<Integer> d;
        Deque<Integer> st;

        public MaxQueue() {
            d = new ArrayDeque<>();
            st = new ArrayDeque<>();
        }

        public int max_value() {
            if (st.isEmpty()) {
                return -1;
            }
            return st.peekFirst();
        }

        public void push_back(int value) {
            d.addLast(value);
            while (!st.isEmpty() && st.peekLast() < value) {
                st.pollLast();
            }
            st.addLast(value);
        }

        public int pop_front() {
            if (d.isEmpty()) {
                return -1;
            }
            int ans = d.pollFirst();
            if (ans == st.peekFirst()) {
                st.pollFirst();
            }
            return ans;
        }
    }

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
        
       