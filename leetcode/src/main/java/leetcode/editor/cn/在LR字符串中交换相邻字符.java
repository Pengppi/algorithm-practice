/**
 * @Title: 777.在LR字符串中交换相邻字符
 * @TitleSlug: SwapAdjacentInLrString
 * @Author: Neo
 * @Date: 2022-10-02 23:40:54
 */
package leetcode.editor.cn;

public class 在LR字符串中交换相邻字符 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 在LR字符串中交换相邻字符().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canTransform(String start, String end) {
            int n = start.length();
            int i = 0, j = 0;
            while (i < n && j < n) {
                while (i < n && start.charAt(i) == 'X') {
                    i++;
                }
                while (j < n && end.charAt(j) == 'X') {
                    j++;
                }
                if (i < n && j < n) {
                    if (start.charAt(i) != end.charAt(j)) {
                        return false;
                    }
                    char c = start.charAt(i);
                    if ((c == 'L' && i < j) || (c == 'R' && i > j)) {
                        return false;
                    }
                    i++;
                    j++;
                }
            }
            while (i < n) {
                if (start.charAt(i) != 'X') {
                    return false;
                }
                i++;
            }
            while (j < n) {
                if (end.charAt(j) != 'X') {
                    return false;
                }
                j++;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
