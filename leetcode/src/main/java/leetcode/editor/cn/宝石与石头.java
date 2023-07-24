/**
 * @Title: 771.宝石与石头
 * @TitleSlug: jewelsAndStones
 * @Author: Neo
 * @Date: 2023-07-24 19:56:51
 */
package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class 宝石与石头 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 宝石与石头().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numJewelsInStones(String jewels, String stones) {
            Set<Character> j = new HashSet<>();
            for (char c : jewels.toCharArray()) {
                j.add(c);
            }
            int ans = 0;
            for (char c : stones.toCharArray()) {
                if (j.contains(c)) {
                    ans++;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       