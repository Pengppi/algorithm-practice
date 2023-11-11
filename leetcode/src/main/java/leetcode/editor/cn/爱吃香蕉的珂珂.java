/**
 * @Title: 875.爱吃香蕉的珂珂
 * @TitleSlug: kokoEatingBananas
 * @Author: Neo
 * @Date: 2023-11-11 11:06:09
 */
package leetcode.editor.cn;

import java.util.Arrays;

public class 爱吃香蕉的珂珂 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 爱吃香蕉的珂珂().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minEatingSpeed(int[] piles, int h) {
            int n = piles.length;
            int l = 1, r = Arrays.stream(piles).max().getAsInt();
            while (l <= r) {
                int m = l + (r - l) / 2;
                long cnt = 0;
                for (int i = 0; i < n; i++) {
                    if (piles[i] <= m) {
                        cnt++;
                    } else {
                        cnt += (piles[i] + m - 1) / m;
                    }
                }
                if (cnt > h) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
            return l;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       