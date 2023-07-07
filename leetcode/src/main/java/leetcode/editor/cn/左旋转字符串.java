/**
 * @Title: 剑指 Offer 58 - II.左旋转字符串
 * @TitleSlug: zuoXuanZhuanZiFuChuanLcof
 * @Author: Neo
 * @Date: 2023-05-27 16:03:38
 */
package leetcode.editor.cn;

public class 左旋转字符串 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 左旋转字符串().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseLeftWords(String s, int n) {
            StringBuilder ans = new StringBuilder();
            ans.append(s.substring(n)).append(s.substring(0, n));
            return ans.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       