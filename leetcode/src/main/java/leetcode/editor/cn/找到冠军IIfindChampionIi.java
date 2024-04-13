/**
 * @Title: 2924.找到冠军 II
 * @TitleSlug: findChampionIi
 * @Author: Neo
 * @Date: 2024-04-13 00:29:50
 */
package leetcode.editor.cn;

public class 找到冠军IIfindChampionIi {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 找到冠军IIfindChampionIi().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findChampion(int n, int[][] edges) {
            int[] inDegree = new int[n];
            for (int[] e : edges) {
                if (inDegree[e[1]]++ == 0) {
                    n--;
                }
            }
            if (n == 1) {
                for (int i = 0; i < inDegree.length; i++) {
                    if (inDegree[i] == 0) {
                        return i;
                    }
                }
            }
            return -1;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       