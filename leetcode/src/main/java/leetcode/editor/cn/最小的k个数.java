/**
 * @Title: 剑指 Offer 40.最小的k个数
 * @TitleSlug: zuiXiaoDeKgeShuLcof
 * @Author: Neo
 * @Date: 2023-04-27 14:32:57
 */
package leetcode.editor.cn;

import java.util.Arrays;

public class 最小的k个数{
public static void main(String[] args) {
        //测试代码
        Solution solution = new 最小的k个数().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        return Arrays.copyOf(arr,k);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
        
       