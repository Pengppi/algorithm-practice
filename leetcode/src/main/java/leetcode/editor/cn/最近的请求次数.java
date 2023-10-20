/**
 * @Title: 933.最近的请求次数
 * @TitleSlug: numberOfRecentCalls
 * @Author: Neo
 * @Date: 2023-10-18 11:27:27
 */
package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class 最近的请求次数 {
    public static void main(String[] args) {
        //测试代码
        RecentCounter solution = new 最近的请求次数().new RecentCounter();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class RecentCounter {

        private Deque<Integer> queue;

        public RecentCounter() {
            queue = new ArrayDeque<>();
        }

        public int ping(int t) {
            while (!queue.isEmpty()&&queue.peekFirst() < t - 3000) {
                queue.pollFirst();
            }
            queue.addLast(t);
            return queue.size();
        }
    }

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
        
       