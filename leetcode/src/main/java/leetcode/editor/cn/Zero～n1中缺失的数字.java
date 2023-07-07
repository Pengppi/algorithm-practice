/**
 * @Title: 剑指 Offer 53 - II.0～n-1中缺失的数字
 * @TitleSlug: queShiDeShuZiLcof
 * @Author: Neo
 * @Date: 2023-05-21 14:09:03
 */
package leetcode.editor.cn;

public class Zero～n1中缺失的数字{
public static void main(String[]args){
        //测试代码
        Solution solution=new Zero～n1中缺失的数字().new Solution();
        }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int ans = n * (n + 1) / 2;
        for (int num : nums) {
            ans -= num;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
        
       