/**
 * @Title: 295.数据流的中位数
 * @TitleSlug: findMedianFromDataStream
 * @Author: Neo
 * @Date: 2024-04-12 00:15:34
 */
package leetcode.editor.cn;

import java.util.PriorityQueue;

public class 数据流的中位数findMedianFromDataStream {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 数据流的中位数findMedianFromDataStream().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class MedianFinder {
        
        private PriorityQueue<Integer> left, right;
        
        public MedianFinder() {
            left = new PriorityQueue<>((a, b) -> (b - a));
            right = new PriorityQueue<>();
        }
        
        public void addNum(int num) {
            if (left.isEmpty() || num <= left.peek()) {
                left.offer(num);
            } else {
                right.offer(num);
            }
            while (left.size() > right.size() + 1) {
                right.offer(left.poll());
            }
            while (right.size() > left.size()) {
                left.offer(right.poll());
            }
        }
        
        public double findMedian() {
            if (left.size() == right.size()) {
                int l = left.peek(), r = right.peek();
                return (l + r) / 2.0;
            } else {
                return left.peek();
            }
        }
    }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
// leetcode submit region end(Prohibit modification and deletion)

}
       