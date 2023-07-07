/**
 * @Title: 1093.大样本统计
 * @TitleSlug: statisticsFromALargeSample
 * @Author: Neo
 * @Date: 2023-05-27 15:19:01
 */
package leetcode.editor.cn;

import java.util.ArrayList;

public class 大样本统计 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 大样本统计().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double[] sampleStats(int[] c) {
            int totalCount = 0;
            long sum = 0;
            int mode = 0, modeCount = 0;
            List<int[]> list = new ArrayList<>();
            for (int i = 0; i < c.length; i++) {
                if (c[i] > 0) {
                    list.add(new int[]{i, c[i]});
                    totalCount += c[i];
                    sum += 1L* i * c[i];
                    if (c[i] > modeCount) {
                        mode = i;
                        modeCount = c[i];
                    }
                }
            }

            int n = list.size();
            int medianPos = (totalCount + 1) / 2;
            double median = 0;
            for (int i = 0; i < n && medianPos > 0; i++) {
                medianPos -= list.get(i)[1];
                if (medianPos < 0) {
                    median = list.get(i)[0];
                    break;
                } else if (medianPos == 0) {
                    if (totalCount % 2 == 0) {
                        median = (list.get(i)[0] + list.get(i + 1)[0]) / 2.0;
                    } else {
                        median = list.get(i)[0];
                    }
                    break;
                }
            }
            int min = list.get(0)[0];
            int max = list.get(n - 1)[0];
            double mean = sum * 1.0 / totalCount;
            double[] ans = new double[]{min, max, mean, median, mode};
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       