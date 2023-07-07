/**
 * @Title: 剑指 Offer 64.求1+2+…+n
 * @TitleSlug: qiu12nLcof
 * @Author: Neo
 * @Date: 2023-05-14 14:16:56
 */
package leetcode.editor.cn;

import java.util.stream.IntStream;

public class 求1+2+…+n{
public static void main(String[]args){
        //测试代码
        Solution solution=new 求1+2+…+n().new Solution();
        }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int sumNums(int n) {
        return IntStream.range(1,n+1).sum();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
        
       