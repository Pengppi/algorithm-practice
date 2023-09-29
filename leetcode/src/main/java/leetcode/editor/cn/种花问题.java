/**
 * @Title: 605.种花问题
 * @TitleSlug: canPlaceFlowers
 * @Author: Neo
 * @Date: 2023-09-29 14:13:36
 */
package leetcode.editor.cn;

public class 种花问题 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 种花问题().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canPlaceFlowers(int[] flowerbed, int n) {
            int len = flowerbed.length;
            for (int i = 0; i < len && n > 0; ) {
                if (flowerbed[i] == 1) {
                    i += 2;
                } else if (i == len - 1 || flowerbed[i + 1] == 0) {
                    flowerbed[i] = 1;
                    n--;
                    i += 2;
                } else {
                    i += 3;
                }
            }
            return n <= 0;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       