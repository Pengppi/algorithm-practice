/**
 * @Title: 1653.使字符串平衡的最少删除次数
 * @TitleSlug: minimumDeletionsToMakeStringBalanced
 * @Author: Neo
 * @Date: 2023-03-06 16:13:57
 */
package leetcode.editor.cn;

public class 使字符串平衡的最少删除次数 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 使字符串平衡的最少删除次数().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumDeletions(String s) {
        int f = 0, cntB = 0;
        for (char c : s.toCharArray()) {
            if (c == 'b') {
                cntB++;
            } else {
                f = Math.min(f + 1, cntB);
            }
        }
        return f;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
}
