/**
 * @Title: 2409.统计共同度过的日子数
 * @TitleSlug: countDaysSpentTogether
 * @Author: Neo
 * @Date: 2023-04-17 15:10:28
 */
package leetcode.editor.cn;


public class 统计共同度过的日子数 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 统计共同度过的日子数().new Solution();
        solution.countDaysTogether("10-01",
                "10-31",
                "11-01",
                "12-31");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
            String ldate = arriveAlice.compareTo(arriveBob) > 0 ? arriveAlice : arriveBob;
            String rdate = leaveAlice.compareTo(leaveBob) < 0 ? leaveAlice : leaveBob;
            if (ldate.compareTo(rdate) >0) {
                return 0;
            }
            int[] daysOfMonth = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            int lm = Integer.parseInt(ldate.substring(0, 2));
            int rm = Integer.parseInt(rdate.substring(0, 2));
            int ld = Integer.parseInt(ldate.substring(3));
            int rd = Integer.parseInt(rdate.substring(3));
            if (lm == rm) {
                return rd - ld + 1;
            }
            int cnt = daysOfMonth[lm-1] - ld + 1 + rd;
            while (++lm < rm) {
                cnt += daysOfMonth[lm-1];
            }
            return cnt;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}

