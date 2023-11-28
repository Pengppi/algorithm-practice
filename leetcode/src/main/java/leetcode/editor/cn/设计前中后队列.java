/**
 * @Title: 1670.设计前中后队列
 * @TitleSlug: designFrontMiddleBackQueue
 * @Author: Neo
 * @Date: 2023-11-28 00:59:52
 */
package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class 设计前中后队列 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 设计前中后队列().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class FrontMiddleBackQueue {

        Deque<Integer> l, r;

        public FrontMiddleBackQueue() {
            l = new ArrayDeque<>();
            r = new ArrayDeque<>();
        }

        public void pushFront(int val) {
            l.addFirst(val);
            if (l.size() > r.size() + 1) {
                r.addFirst(l.pollLast());
            }
        }

        public void pushMiddle(int val) {
            if (l.size() > r.size()) {
                r.addFirst(l.pollLast());
                l.addLast(val);
            } else {
                l.addLast(val);
            }
        }

        public void pushBack(int val) {
            r.addLast(val);
            if (r.size() > l.size()) {
                l.addLast(r.pollFirst());
            }
        }

        public int popFront() {
            if (l.isEmpty()) {
                return -1;
            }
            int x = l.pollFirst();
            if (l.size() < r.size()) {
                l.addLast(r.pollFirst());
            }
            return x;
        }

        public int popMiddle() {
            if (l.isEmpty()) {
                return -1;
            }
            int x = l.pollLast();
            if (l.size() < r.size()) {
                l.addLast(r.pollFirst());
            }
            return x;
        }

        public int popBack() {
            if (r.isEmpty()) {
                if (l.isEmpty()) {
                    return -1;
                } else {
                    return l.pollLast();
                }
            }
            int x = r.pollLast();
            if (r.size() + 1 < l.size()) {
                r.addFirst(l.pollLast());
            }
            return x;
        }
    }

/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
 * obj.pushFront(val);
 * obj.pushMiddle(val);
 * obj.pushBack(val);
 * int param_4 = obj.popFront();
 * int param_5 = obj.popMiddle();
 * int param_6 = obj.popBack();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
        
       