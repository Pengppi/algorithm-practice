/**
 * @Title: 2379.得到 K 个黑块的最少涂色次数
 * @TitleSlug: minimumRecolorsToGetKConsecutiveBlackBlocks
 * @Author: Neo
 * @Date: 2023-04-17 15:35:56
 */
package leetcode.editor.cn;

public class 得到K个黑块的最少涂色次数 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 得到K个黑块的最少涂色次数().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumRecolors(String blocks, int k) {
            int n = blocks.length();
            int cnt = 0;
            for (int i = 0; i < k; i++) {
                if (blocks.charAt(i) == 'W') {
                    cnt++;
                }
            }
            int res = cnt;
            for (int i = k; i < n; i++) {
                if (blocks.charAt(i - k) != blocks.charAt(i)) {
                    cnt += blocks.charAt(i) == 'W' ? 1 : -1;
                    res = Math.min(res, cnt);
                }
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}

