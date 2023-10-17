/**
 * @Title: 2652.倍数求和
 * @TitleSlug: sumMultiples
 * @Author: Neo
 * @Date: 2023-10-17 14:22:28
 */
package leetcode.editor.cn;

public class 倍数求和 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 倍数求和().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int sumOfMultiples(int n) {
            int ans = 0;
            for (int i = 1; i <=n; i++) {
                if (i % 3 == 0 || i % 5 == 0 || i % 7 == 0) {
                    ans += i;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       