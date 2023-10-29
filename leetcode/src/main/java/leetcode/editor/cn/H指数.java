/**
 * @Title: 274.H 指数
 * @TitleSlug: hIndex
 * @Author: Neo
 * @Date: 2023-10-29 23:48:11
 */
package leetcode.editor.cn;

import java.util.Arrays;

public class H指数 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new H指数().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int hIndex(int[] citations) {
            Arrays.sort(citations);
            int i = citations.length - 1, h = 0;
            while (i >= 0 && citations[i] > h) {
                h++;
                i--;
            }
            return h;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       