/**
 * @Title: 886.可能的二分法
 * @TitleSlug: PossibleBipartition
 * @Author: Neo
 * @Date: 2022-10-30 10:03:47
 */
package leetcode.editor.cn;

public class 可能的二分法 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 可能的二分法().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] p = new int[4010];

        int find(int x) {
            if (p[x] != x) {
                p[x] = find(p[x]);
            }
            return p[x];
        }

        void union(int a, int b) {
            p[find(a)] = p[find(b)];
        }

        boolean query(int a, int b) {
            return find(a) == find(b);
        }

        public boolean possibleBipartition(int n, int[][] dislikes) {
            for (int i = 1; i <= 2 * n; i++) {
                p[i] = i;
            }
            for (int[] d : dislikes) {
                int a = d[0], b = d[1];
                if (query(a, b)) {
                    return false;
                }
                union(a, b + n);
                union(b, a + n);
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
