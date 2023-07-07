/**
 * @Title: 2446.判断两个事件是否存在冲突
 * @TitleSlug: determineIfTwoEventsHaveConflict
 * @Author: Neo
 * @Date: 2023-05-17 17:51:04
 */
package leetcode.editor.cn;

public class 判断两个事件是否存在冲突 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 判断两个事件是否存在冲突().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean haveConflict(String[] event1, String[] event2) {

            return event1[0].compareTo(event2[0]) < 0 ? event1[1].compareTo(event2[0]) >= 0 :
                    event2[1].compareTo(event1[0]) >= 0;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
        
       