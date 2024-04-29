/**
 * @Title: 933.最近的请求次数
 * @TitleSlug: numberOfRecentCalls
 * @Author: Neo
 * @Date: 2024-04-29 16:15:12
 */
package leetcode.editor.cn;

import java.util.TreeSet;

public class 最近的请求次数numberOfRecentCalls {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 最近的请求次数numberOfRecentCalls().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class RecentCounter {
        
        private TreeSet<Integer> queue;
        
        public RecentCounter() {
            queue = new TreeSet<>();
        }
        
        public int ping(int t) {
            queue.add(t);
            while (queue.first() < t - 3000) {
                queue.pollFirst();
            }
            return queue.size();
        }
    }

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
// leetcode submit region end(Prohibit modification and deletion)

}
       