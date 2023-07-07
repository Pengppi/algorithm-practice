/**
 * @Title: 901.股票价格跨度
 * @TitleSlug: OnlineStockSpan
 * @Author: Neo
 * @Date: 2022-10-21 00:31:57
 */
package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class 股票价格跨度 {
    public static void main(String[] args) {
        //测试代码
        StockSpanner solution = new 股票价格跨度().new StockSpanner();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class StockSpanner {
        private Deque<int[]> deque;

        public StockSpanner() {
            deque = new ArrayDeque<>();
        }

        public int next(int price) {
            int cnt = 1;
            while (!deque.isEmpty() && deque.peekLast()[0] <= price) {
                cnt += deque.pollLast()[1];
            }
            deque.addLast(new int[]{price, cnt});
            return cnt;
        }
    }

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
