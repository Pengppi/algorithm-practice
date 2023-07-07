/**
 * @Title: 2600.K 件物品的最大和
 * @TitleSlug: kItemsWithTheMaximumSum
 * @Author: Neo
 * @Date: 2023-07-05 17:30:33
 */
package leetcode.editor.cn;

public class K件物品的最大和 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new K件物品的最大和().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
            if (numOnes >= k) {
                return k;
            }
            k -= numOnes;
            k -= numZeros;
            if (k <= 0) {
                return numOnes;
            } else {
                return numOnes - k;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       