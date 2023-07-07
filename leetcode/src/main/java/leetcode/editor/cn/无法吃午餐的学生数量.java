/**
 * @Title: 1700.无法吃午餐的学生数量 
 * @TitleSlug: NumberOfStudentsUnableToEatLunch
 * @Author: Neo
 * @Date: 2022-10-19 08:32:41
 */
package leetcode.editor.cn;
public class 无法吃午餐的学生数量{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 无法吃午餐的学生数量().new Solution();
    }
      
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int[] count = new int[2];
        for (int student : students) {
            count[student]++;
        }
        for (int i = 0; i < sandwiches.length; i++) {
            if (count[sandwiches[i]] == 0) {
                return sandwiches.length - i;
            }
            count[sandwiches[i]]--;
        }
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
