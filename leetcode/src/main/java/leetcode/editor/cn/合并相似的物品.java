/**
 * @Title: 2363.合并相似的物品
 * @TitleSlug: MergeSimilarItems
 * @Author: Neo
 * @Date: 2023-02-28 22:23:20
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 合并相似的物品 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 合并相似的物品().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(items1, (o1, o2) -> o1[0] - o2[0]);
            Arrays.sort(items2, (o1, o2) -> o1[0] - o2[0]);
            int i = 0, j = 0;
            while (i < items1.length || j < items2.length) {
                if (i == items1.length) {
                    res.add(Arrays.asList(items2[j][0], items2[j][1]));
                    j++;
                    continue;
                }
                if (j == items2.length) {
                    res.add(Arrays.asList(items1[i][0], items1[i][1]));
                    i++;
                    continue;
                }
                if (items1[i][0] == items2[j][0]) {
                    res.add(Arrays.asList(items1[i][0], items1[i][1] + items2[j][1]));
                    i++;
                    j++;
                } else if (items1[i][0] < items2[j][0]) {
                    res.add(Arrays.asList(items1[i][0], items1[i][1]));
                    i++;
                } else {
                    res.add(Arrays.asList(items2[j][0], items2[j][1]));
                    j++;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
