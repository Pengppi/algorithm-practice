/**
 * @Title: 2651.计算列车到站时间
 * @TitleSlug: calculateDelayedArrivalTime
 * @Author: Neo
 * @Date: 2023-09-08 00:11:01
 */
package leetcode.editor.cn;
public class 计算列车到站时间{
public static void main(String[] args) {
        //测试代码
        Solution solution = new 计算列车到站时间().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
        return (arrivalTime+delayedTime)%24;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
        
       