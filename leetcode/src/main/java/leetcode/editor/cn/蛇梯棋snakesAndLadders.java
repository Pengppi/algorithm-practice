/**
 * @Title: 909.蛇梯棋
 * @TitleSlug: snakesAndLadders
 * @Author: Neo
 * @Date: 2024-03-20 17:35:12
 */
package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class 蛇梯棋snakesAndLadders {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 蛇梯棋snakesAndLadders().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int n;
        
        public int snakesAndLadders(int[][] board) {
            this.n = board.length;
            int ans = 0;
            Deque<Integer> queue = new ArrayDeque<>();
            queue.add(1);
            boolean[] visited = new boolean[n * n + 1];
            visited[1] = true;
            while (!queue.isEmpty()) {
                for (int k = queue.size(); k > 0; k--) {
                    int cur = queue.poll();
                    for (int x = cur + 1; x <= Math.min(cur + 6, n * n); x++) {
                        int dest = x;
                        int[] pos = getPos(x);
                        if (board[pos[0]][pos[1]] != -1) {
                            dest = board[pos[0]][pos[1]];
                        }
                        if (visited[dest]) {
                            continue;
                        }
                        if (dest == n * n) {
                            return ans + 1;
                        }
                        visited[dest] = true;
                        queue.add(dest);
                    }
                }
                ans++;
            }
            return -1;
        }
        
        private int[] getPos(int num) {
            num--;
            int x = n - 1 - num / n;
            int y = num % n;
            if (x % 2 == n % 2) {
                y = n - 1 - y;
            }
            return new int[]{x, y};
        }
        
        private int getNum(int x, int y) {
            if (x % 2 == n % 2) {
                y = n - 1 - y;
            }
            return n * (n - 1 - x) + y + 1;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       