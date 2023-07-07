/**
 * @Title: 2455.可被三整除的偶数的平均值
 * @TitleSlug: averageValueOfEvenNumbersThatAreDivisibleByThree
 * @Author: Neo
 * @Date: 2023-05-29 14:47:20
 */
package leetcode.editor.cn;
public class 可被三整除的偶数的平均值{
public static void main(String[] args) {
        //测试代码
        Solution solution = new 可被三整除的偶数的平均值().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int averageValue(int[] nums) {
        int sum = 0, cnt = 0;
        for (int i : nums) {
            if (i % 2 == 0 && i % 3 == 0) {
                sum += i;
                cnt++;
            }
        }
        return cnt == 0 ? 0 : sum / cnt;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
        
       