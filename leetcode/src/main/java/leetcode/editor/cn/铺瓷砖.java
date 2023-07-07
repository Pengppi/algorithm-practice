/**
 * @Title: 1240.铺瓷砖
 * @TitleSlug: tilingARectangleWithTheFewestSquares
 * @Author: Neo
 * @Date: 2023-06-08 17:05:42
 */
package leetcode.editor.cn;

public class 铺瓷砖 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 铺瓷砖().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int tilingRectangle(int n, int m) {
            int[][] anss = {
                    {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13},
                    {2, 1, 3, 2, 4, 3, 5, 4, 6, 5, 7, 6, 8},
                    {3, 3, 1, 3, 4, 2, 5, 5, 3, 6, 6, 4, 7},
                    {4, 2, 4, 1, 5, 3, 5, 2, 6, 4, 6, 3, 7},
                    {5, 4, 4, 5, 1, 5, 5, 5, 6, 2, 6, 6, 6},
                    {6, 3, 2, 3, 5, 1, 5, 4, 5, 4, 6, 2, 6},
                    {7, 5, 5, 5, 5, 5, 1, 7, 6, 6, 6, 6, 6},
                    {8, 4, 5, 2, 5, 4, 7, 1, 7, 5, 6, 3, 6},
                    {9, 6, 3, 6, 6, 3, 6, 7, 1, 6, 7, 4, 7},
                    {10, 5, 6, 4, 2, 4, 6, 5, 6, 1, 6, 5, 7},
                    {11, 7, 6, 6, 6, 6, 6, 6, 7, 6, 1, 7, 6},
                    {12, 6, 4, 3, 6, 2, 6, 3, 4, 5, 7, 1, 7},
                    {13, 8, 7, 7, 6, 6, 6, 6, 7, 7, 6, 7, 1}
            };
            return anss[n-1][m-1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       