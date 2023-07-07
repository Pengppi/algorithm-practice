/**
 * @Title: 剑指 Offer 43.1～n 整数中 1 出现的次数
 * @TitleSlug: oneNzhengShuZhong1chuXianDeCiShuLcof
 * @Author: Neo
 * @Date: 2023-05-14 15:18:15
 */
package leetcode.editor.cn;

public class One～n整数中1出现的次数{
public static void main(String[]args){
        //测试代码
        Solution solution=new One～n整数中1出现的次数().new Solution();
        }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countDigitOne(int n) {
        int high = n;
        int digit = 1;
        int low = 0;
        int ans = 0;
        while (high != 0) {
            int cur = high % 10;
            high /= 10;
            if (cur == 0) {
                ans += high * digit;
            } else if (cur == 1) {
                ans += high * digit + low + 1;
            } else {
                ans += (high + 1) * digit;
            }
            low += cur * digit;
            digit *= 10;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
        
       