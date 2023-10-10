/**
 * @Title: 1732.找到最高海拔
 * @TitleSlug: findTheHighestAltitude
 * @Author: Neo
 * @Date: 2023-10-10 22:41:32
 */
package leetcode.editor.cn;

public class 找到最高海拔 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 找到最高海拔().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int largestAltitude(int[] gain) {
            int ans = 0, sum = 0;
            for (int i : gain) {
                sum += i;
                ans = Math.max(ans, sum);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       