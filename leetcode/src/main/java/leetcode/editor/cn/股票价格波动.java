/**
 * @Title: 2034.股票价格波动
 * @TitleSlug: stockPriceFluctuation
 * @Author: Neo
 * @Date: 2023-10-08 23:02:49
 */
package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class 股票价格波动 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 股票价格波动().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class StockPrice {

        int cur;
        Map<Integer, Integer> map;
        TreeMap<Integer, Integer> prices;

        public StockPrice() {
            cur = -1;
            map = new HashMap<>();
            prices = new TreeMap<>();
        }

        public void update(int timestamp, int price) {
            cur = Math.max(cur, timestamp);
            int prevPrice = map.getOrDefault(timestamp, 0);
            if (prevPrice > 0) {
                prices.put(prevPrice, prices.get(prevPrice) - 1);
                if (prices.get(prevPrice) == 0) {
                    prices.remove(prevPrice);
                }
            }
            map.put(timestamp, price);
            prices.put(price, prices.getOrDefault(price, 0) + 1);

        }

        public int current() {
            return map.get(cur);
        }

        public int maximum() {
            return prices.lastKey();
        }


        public int minimum() {
            return prices.firstKey();
        }

    }

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
        
       