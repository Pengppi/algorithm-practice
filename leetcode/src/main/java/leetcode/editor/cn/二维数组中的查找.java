/**
 * @Title: 剑指 Offer 04.二维数组中的查找
 * @TitleSlug: erWeiShuZuZhongDeChaZhaoLcof
 * @Author: Neo
 * @Date: 2023-06-11 15:18:51
 */
package leetcode.editor.cn;

public class 二维数组中的查找 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 二维数组中的查找().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean findNumberIn2DArray(int[][] matrix, int target) {
            int n = matrix.length;
            if (n == 0) {
                return false;
            }
            int m = matrix[0].length;
            if (m == 0) {
                return false;
            }
            for (int[] arr : matrix) {
                if (arr[0] > target) break;
                if (arr[m - 1] < target) continue;
                int l = 0, r = m - 1;
                while (l <= r) {
                    int mid = (l + r) / 2;
                    if (arr[mid] < target) {
                        l = mid + 1;
                    } else if (arr[mid] == target) {
                        return true;
                    } else {
                        r = mid - 1;
                    }
                }
            }
            return false;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       