/**
 * @Title: 剑指 Offer 41.数据流中的中位数
 * @TitleSlug: shuJuLiuZhongDeZhongWeiShuLcof
 * @Author: Neo
 * @Date: 2023-07-07 17:36:49
 */
package leetcode.editor.cn;


import java.util.PriorityQueue;

public class 数据流中的中位数 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 数据流中的中位数().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MedianFinder {

        /**
         * initialize your data structure here.
         */

        private PriorityQueue<Integer> l;
        private PriorityQueue<Integer> r;

        public MedianFinder() {
            l = new PriorityQueue<>((a, b) -> (b - a));
            r = new PriorityQueue<>();
        }

        public void addNum(int num) {
            if (l.isEmpty() || num <= l.peek()) {
                l.offer(num);
                if (r.size() + 1 < l.size()) {
                    r.offer(l.poll());
                }
            } else {
                r.offer(num);
                if (r.size() > l.size()) {
                    l.offer(r.poll());
                }
            }
        }

        public double findMedian() {
            if (l.size() > r.size()) {
                return (double) l.peek();
            } else {
                return (double) (l.peek() + r.peek()) / 2.0;
            }
        }
    }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
        
       