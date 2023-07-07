/**
 * @Title: 1105.填充书架
 * @TitleSlug: fillingBookcaseShelves
 * @Author: Neo
 * @Date: 2023-04-23 00:35:05
 */
package leetcode.editor.cn;
public class 填充书架{
public static void main(String[] args) {
        //测试代码
        Solution solution = new 填充书架().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        int[] f = new int[n + 1];
        Arrays.fill(f, Integer.MAX_VALUE);
        f[0] = 0;
        for (int i = 1; i <= n; i++) {
            int width = 0, height = 0;
            for (int j = i - 1; j >= 0; j--) {
                width += books[j][0];
                if (width > shelfWidth) {
                    break;
                }
                height = Math.max(height, books[j][1]);
                f[i] = Math.min(f[i], f[j] + height);
            }
        }
        return f[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
        
       