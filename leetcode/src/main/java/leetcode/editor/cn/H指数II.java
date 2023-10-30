/**
 * @Title: 275.H 指数 II
 * @TitleSlug: hIndexIi
 * @Author: Neo
 * @Date: 2023-10-30 00:16:49
 */
package leetcode.editor.cn;

public class H指数II {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new H指数II().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int hIndex(int[] citations) {
            int h = 0, i = citations.length - 1;
            while (i >= 0 && citations[i] > h) {
                h++;
                i--;
            }
            return h;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       