/**
 * @Title: 649.Dota2 参议院
 * @TitleSlug: dota2Senate
 * @Author: Neo
 * @Date: 2023-10-22 14:25:40
 */
package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class Dota2参议院 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new Dota2参议院().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String predictPartyVictory(String senate) {
            String[] ans = new String[]{"Radiant", "Dire"};
            int r = 0, d = 0, n = senate.length();
            Deque<Integer> queue = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                char c = senate.charAt(i);
                if (c == 'R') {
                    r++;
                    queue.add(0);
                } else {
                    d++;
                    queue.add(1);
                }
            }
            int kr = 0, kd = 0;
            while (r != 0 && d != 0) {
                int t = queue.remove();
                if (t == 0) {
                    if (kr == 0) {
                        kd++;
                        queue.add(t);
                    } else {
                        kr--;
                        r--;
                    }
                } else {
                    if (kd == 0) {
                        kr++;
                        queue.add(t);
                    } else {
                        kd--;
                        d--;
                    }
                }
            }
            return d == 0 ? ans[0] : ans[1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       