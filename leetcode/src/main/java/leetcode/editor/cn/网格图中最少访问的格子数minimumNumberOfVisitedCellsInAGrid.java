/**
 * @Title: 2617.网格图中最少访问的格子数
 * @TitleSlug: minimumNumberOfVisitedCellsInAGrid
 * @Author: Neo
 * @Date: 2024-03-22 16:27:42
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 网格图中最少访问的格子数minimumNumberOfVisitedCellsInAGrid {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 网格图中最少访问的格子数minimumNumberOfVisitedCellsInAGrid().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumVisitedCells(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            ArrayList<int[]>[] colStacks = new ArrayList[n];
            Arrays.setAll(colStacks, i -> new ArrayList<>());
            ArrayList<int[]> rowStack = new ArrayList<>();
            int cnt = 0;
            for (int i = m - 1; i >= 0; i--) {
                rowStack.clear();
                for (int j = n - 1; j >= 0; j--) {
                    ArrayList<int[]> colStack = colStacks[j];
                    int g = grid[i][j];
                    cnt = i < m - 1 || j < n - 1 ? Integer.MAX_VALUE : 1;
                    if (g > 0) {
                        int k = lower_bound(rowStack, j + g);
                        if (k < rowStack.size()) {
                            cnt = rowStack.get(k)[0] + 1;
                        }
                        k = lower_bound(colStack, i + g);
                        if (k < colStack.size()) {
                            cnt = Math.min(cnt, colStack.get(k)[0] + 1);
                        }
                    }
                    if (cnt < Integer.MAX_VALUE) {
                        while (!rowStack.isEmpty() && peek(rowStack) >= cnt) {
                            pop(rowStack);
                        }
                        rowStack.add(new int[]{cnt, j});
                        while (!colStack.isEmpty() && peek(colStack) >= cnt) {
                            pop(colStack);
                        }
                        colStack.add(new int[]{cnt, i});
                    }
                }
                
            }
            return cnt == Integer.MAX_VALUE ? -1 : cnt;
        }
        
        private int lower_bound(List<int[]> arr, int t) {
            int l = -1, r = arr.size();
            while (l + 1 < r) {
                int m = l + (r - l) / 2;
                if (arr.get(m)[1] > t) {
                    l = m;
                } else {
                    r = m;
                }
            }
            return r;
        }
        
        private int peek(List<int[]> list) {
            return list.get(list.size() - 1)[0];
        }
        
        private void pop(List<int[]> list) {
            list.remove(list.size() - 1);
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       