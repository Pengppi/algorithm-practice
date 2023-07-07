/**
 * @Title: 剑指 Offer 53 - I.在排序数组中查找数字 I
 * @TitleSlug: zaiPaiXuShuZuZhongChaZhaoShuZiLcof
 * @Author: Neo
 * @Date: 2023-05-21 14:09:01
 */
package leetcode.editor.cn;

import java.util.Arrays;

public class 在排序数组中查找数字I {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 在排序数组中查找数字I().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int search(int[] nums, int target) {
            return (int) Arrays.stream(nums).filter(x -> x == target).count();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       