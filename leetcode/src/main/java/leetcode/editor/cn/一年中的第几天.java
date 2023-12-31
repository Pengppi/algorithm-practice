/**
 * @Title: 1154.一年中的第几天
 * @TitleSlug: dayOfTheYear
 * @Author: Neo
 * @Date: 2023-12-31 00:20:02
 */
package leetcode.editor.cn;

import java.time.LocalDate;

public class 一年中的第几天 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 一年中的第几天().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
//import java.time.LocalDate;
    
    class Solution {
        public int dayOfYear(String date) {
            String[] d = date.split("-");
            int year = Integer.parseInt(d[0]);
            int month = Integer.parseInt(d[1]);
            int day = Integer.parseInt(d[2]);
            return LocalDate.of(year, month, day).getDayOfYear();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       