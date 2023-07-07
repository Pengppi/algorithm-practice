/**
 * @Title: 2611.老鼠和奶酪
 * @TitleSlug: miceAndCheese
 * @Author: Neo
 * @Date: 2023-06-07 18:09:59
 */
package leetcode.editor.cn;

import java.util.HashMap;
import java.util.PriorityQueue;

public class 老鼠和奶酪 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 老鼠和奶酪().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int miceAndCheese(int[] reward1, int[] reward2, int k) {
            int n = reward1.length;
            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
            int ans = 0;
            for (int i = 0; i < n; i++) {
                pq.offer(reward1[i] - reward2[i]);
                ans += reward2[i];
            }
            while (k-- > 0) {
                int t = pq.poll();
                ans += t;
            }
            return ans;cewd
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       