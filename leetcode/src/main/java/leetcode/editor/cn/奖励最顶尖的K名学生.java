/**
 * @Title: 2512.奖励最顶尖的 K 名学生
 * @TitleSlug: rewardTopKStudents
 * @Author: Neo
 * @Date: 2023-10-11 00:15:43
 */
package leetcode.editor.cn;

import java.util.*;

public class 奖励最顶尖的K名学生 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 奖励最顶尖的K名学生().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
            Set<String> pos = new HashSet<>();
            Set<String> neg = new HashSet<>();
            pos.addAll(Arrays.asList(positive_feedback));
            neg.addAll(Arrays.asList(negative_feedback));
            int n = student_id.length;
            Integer[][] score = new Integer[n][2];
            for (int i = 0; i < n; i++) {
                int totalScore = 0;
                for (String word : report[i].split(" ")) {
                    if (pos.contains(word)) {
                        totalScore += 3;
                    } else if (neg.contains(word)) {
                        totalScore -= 1;
                    }
                }
                score[i][0] = totalScore;
                score[i][1] = student_id[i];
            }
            Arrays.sort(score, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]));
            List<Integer> ans = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                ans.add(score[i][1]);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       