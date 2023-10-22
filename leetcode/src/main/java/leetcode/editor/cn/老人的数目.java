/**
 * @Title: 2678.老人的数目
 * @TitleSlug: numberOfSeniorCitizens
 * @Author: Neo
 * @Date: 2023-10-23 00:11:32
 */
package leetcode.editor.cn;

public class 老人的数目 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 老人的数目().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countSeniors(String[] details) {
            int ans = 0;
            for (String d : details) {
                String s = d.substring(11, 13);
                if (Integer.valueOf(s) > 60) {
                    ans++;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       