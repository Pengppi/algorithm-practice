/**
 * @Title: 630.课程表 III
 * @TitleSlug: courseScheduleIii
 * @Author: Neo
 * @Date: 2023-09-11 14:40:35
 */
package leetcode.editor.cn;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 课程表III {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 课程表III().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int scheduleCourse(int[][] courses) {
            Arrays.sort(courses, (a, b) -> (a[1] - b[1]));
            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
            int day = 0;
            for (int[] c : courses) {
                if (day + c[0] <= c[1]) {
                    pq.add(c[0]);
                    day += c[0];
                } else if (!pq.isEmpty() && c[0] < pq.peek()) {
                    day = day - pq.poll() + c[0];
                    pq.add(c[0]);
                }
            }
            return pq.size();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       