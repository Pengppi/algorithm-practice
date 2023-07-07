/**
 * @Title: 剑指 Offer 03.数组中重复的数字
 * @TitleSlug: shuZuZhongZhongFuDeShuZiLcof
 * @Author: Neo
 * @Date: 2023-06-11 15:42:36
 */
package leetcode.editor.cn;

public class 数组中重复的数字 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 数组中重复的数字().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findRepeatNumber(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                if (!set.add(num)) {
                    return num;
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       