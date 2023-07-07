/**
 * @Title: 2532.过桥的时间
 * @TitleSlug: timeToCrossABridge
 * @Author: Neo
 * @Date: 2023-07-07 08:56:13
 */
package leetcode.editor.cn;

import sun.awt.windows.WWindowPeer;

import javax.print.DocFlavor;
import java.util.PriorityQueue;

public class 过桥的时间 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 过桥的时间().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findCrossingTime(int n, int k, int[][] time) {
            PriorityQueue<Integer> waitLeft = new PriorityQueue<>((a, b) -> {
                int t1 = time[a][0] + time[a][2];
                int t2 = time[b][0] + time[b][2];
                return t1 == t2 ? b - a : t2 - t1;
            });
            PriorityQueue<Integer> waitRight = new PriorityQueue<>((a, b) -> {
                int t1 = time[a][0] + time[a][2];
                int t2 = time[b][0] + time[b][2];
                return t1 == t2 ? b - a : t2 - t1;
            });
            PriorityQueue<int[]> workLeft = new PriorityQueue<>((a, b) -> {
                return a[0] == b[0] ? a[1] - b[1] : a[0] - b[0];
            });
            PriorityQueue<int[]> workRight = new PriorityQueue<>((a, b) -> {
                return a[0] == b[0] ? a[1] - b[1] : a[0] - b[0];
            });

            int remain = n, curTime = 0;
            for (int i = 0; i < k; i++) {
                waitLeft.add(i);
            }
            while (remain > 0 || !workRight.isEmpty() || !waitRight.isEmpty()) {
                while (!workLeft.isEmpty() && workLeft.peek()[0] <= curTime) {
                    waitLeft.add(workLeft.poll()[1]);
                }
                while (!workRight.isEmpty() && workRight.peek()[0] <= curTime) {
                    waitRight.add(workRight.poll()[1]);
                }
                if (!waitRight.isEmpty()) {
                    int id = waitRight.poll();
                    curTime += time[id][2];
                    workLeft.add(new int[]{curTime + time[id][3], id});
                } else if (remain > 0 && !waitLeft.isEmpty()) {
                    int id = waitLeft.poll();
                    curTime += time[id][0];
                    workRight.add(new int[]{curTime + time[id][1], id});
                    remain--;
                } else {
                    int nextTime = Integer.MAX_VALUE;
                    if (!workLeft.isEmpty()) {
                        nextTime = Math.min(nextTime, workLeft.peek()[0]);
                    }
                    if (!workRight.isEmpty()) {
                        nextTime = Math.min(nextTime, workRight.peek()[0]);
                    }
                    if (nextTime != Integer.MAX_VALUE) {
                        curTime = Math.max(curTime,nextTime);
                    }
                }
            }
            return curTime;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       