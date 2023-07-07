/**
 * @Title: 1574.删除最短的子数组使剩余数组有序
 * @TitleSlug: shortestSubarrayToBeRemovedToMakeArraySorted
 * @Author: Neo
 * @Date: 2023-03-25 14:54:37
 */
package leetcode.editor.cn;

public class 删除最短的子数组使剩余数组有序 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 删除最短的子数组使剩余数组有序().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        int j = n - 1;
        while (j - 1 >= 0 && arr[j - 1] <= arr[j]) {
            j--;
        }
        if (j == 0) {
            return 0;
        }
        int ans = j;
        for (int i = 0; i < n; i++) {
            while (j < n && arr[i] > arr[j]) {
                j++;
            }
            ans = Math.min(ans, j - i - 1);
            if (i + 1 < n && arr[i] > arr[i + 1]) {
                break;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
}
