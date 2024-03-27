/**
 * @Title: LCR 041.数据流中的移动平均值
 * @TitleSlug: qIsx9U
 * @Author: Neo
 * @Date: 2024-03-27 09:16:46
 */
package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class 数据流中的移动平均值qIsx9U {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 数据流中的移动平均值qIsx9U().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class MovingAverage {
        private final int maxSize;
        private Deque<Integer> queue;
        private int sum = 0;
        
        /**
         * Initialize your data structure here.
         */
        public MovingAverage(int size) {
            maxSize = size;
            queue = new ArrayDeque<>();
        }
        
        public double next(int val) {
            queue.offer(val);
            sum += val;
            if (queue.size() > maxSize) {
                sum -= queue.poll();
            }
            return (double) sum / queue.size();
        }
    }

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
// leetcode submit region end(Prohibit modification and deletion)

}
       