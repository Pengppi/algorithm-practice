/**
 * @Title: 1253.重构 2 行二进制矩阵
 * @TitleSlug: reconstructA2RowBinaryMatrix
 * @Author: Neo
 * @Date: 2023-06-29 16:20:47
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;

public class 重构2行二进制矩阵 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 重构2行二进制矩阵().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
            if (Arrays.stream(colsum).sum() != upper + lower) {
                return new ArrayList<>();
            }
            List<List<Integer>> ans = new ArrayList<>();
            int n = colsum.length;
            List<Integer> up = new ArrayList<>(n);
            List<Integer> low = new ArrayList<>(n);
            ans.add(up);
            ans.add(low);
            for (int i = 0; i < n; i++) {
                if (colsum[i] == 2) {
                    up.add(1);
                    low.add(1);
                    upper--;
                    lower--;
                } else if (colsum[i] == 1) {
                    if (upper >= lower) {
                        up.add(1);
                        low.add(0);
                        upper--;
                    } else {
                        up.add(0);
                        low.add(1);
                        lower--;
                    }
                } else {
                    up.add(0);
                    low.add(0);
                }
            }
            if (upper != 0 || lower != 0) {
                return new ArrayList<>();
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       