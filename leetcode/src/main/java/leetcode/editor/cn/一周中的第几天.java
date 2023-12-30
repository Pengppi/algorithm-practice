/**
 * @Title: 1185.一周中的第几天
 * @TitleSlug: dayOfTheWeek
 * @Author: Neo
 * @Date: 2023-12-30 23:33:36
 */
package leetcode.editor.cn;

import java.time.LocalDate;

public class 一周中的第几天 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 一周中的第几天().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        String[] dayOfWeek = {
                "Monday",
                "Tuesday",
                "Wednesday",
                "Thursday",
                "Friday",
                "Saturday",
                "Sunday"
        };

        public String dayOfTheWeek(int day, int month, int year) {
            int value = LocalDate.of(year, month, day).getDayOfWeek().getValue();
            return dayOfWeek[value - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       