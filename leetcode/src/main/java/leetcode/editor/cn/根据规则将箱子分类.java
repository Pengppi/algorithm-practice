/**
 * @Title: 2525.根据规则将箱子分类
 * @TitleSlug: categorizeBoxAccordingToCriteria
 * @Author: Neo
 * @Date: 2023-10-20 23:25:29
 */
package leetcode.editor.cn;

public class 根据规则将箱子分类 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 根据规则将箱子分类().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String categorizeBox(int length, int width, int height, int mass) {
            long maxd = Math.max(length, Math.max(width, height)), vol = 1L * length * width * height;
            boolean isBulky = maxd >= 10000 || vol >= (int)1e+9, isHeavy = mass >= 100;
            if (isBulky && isHeavy) {
                return "Both";
            } else if (isBulky) {
                return "Bulky";
            } else if (isHeavy) {
                return "Heavy";
            } else {
                return "Neither";
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       