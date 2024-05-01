/**
 * @Title: 2798.满足目标工作时长的员工数目
 * @TitleSlug: numberOfEmployeesWhoMetTheTarget
 * @Author: Neo
 * @Date: 2024-04-30 00:09:12
 */
package leetcode.editor.cn;

import java.util.Arrays;

public class 满足目标工作时长的员工数目numberOfEmployeesWhoMetTheTarget {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 满足目标工作时长的员工数目numberOfEmployeesWhoMetTheTarget().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
            return (int) Arrays.stream(hours).filter(hour -> hour >= target).count();
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       