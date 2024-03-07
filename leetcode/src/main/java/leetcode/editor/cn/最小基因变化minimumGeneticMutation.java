/**
 * @Title: 433.最小基因变化
 * @TitleSlug: minimumGeneticMutation
 * @Author: Neo
 * @Date: 2024-03-07 10:08:30
 */
package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class 最小基因变化minimumGeneticMutation {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 最小基因变化minimumGeneticMutation().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minMutation(String startGene, String endGene, String[] bank) {
            int n = bank.length;
            boolean[] used = new boolean[n];
            Deque<String> queue = new ArrayDeque<>();
            queue.offer(startGene);
            int ans = 0;
            while (!queue.isEmpty()) {
                for (int k = queue.size(); k > 0; k--) {
                    String cur = queue.poll();
                    if (cur.equals(endGene)) {
                        return ans;
                    }
                    for (int i = 0; i < n; i++) {
                        if (!used[i] && isValid(cur, bank[i])) {
                            used[i] = true;
                            queue.offer(bank[i]);
                        }
                    }
                }
                ans++;
            }
            return -1;
        }
        
        private boolean isValid(String gen1, String gen2) {
            int cnt = 0;
            for (int i = 0; i < gen1.length(); i++) {
                if (gen1.charAt(i) != gen2.charAt(i)) {
                    cnt++;
                }
                if (cnt > 1) {
                    return false;
                }
            }
            return cnt == 1;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       