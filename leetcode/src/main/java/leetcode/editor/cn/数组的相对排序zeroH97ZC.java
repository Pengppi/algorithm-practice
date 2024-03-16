/**
 * @Title: LCR 075.数组的相对排序
 * @TitleSlug: zeroH97ZC
 * @Author: Neo
 * @Date: 2024-03-15 19:01:14
 */
package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 数组的相对排序zeroH97ZC {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 数组的相对排序zeroH97ZC().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] relativeSortArray(int[] arr1, int[] arr2) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < arr2.length; i++) {
                map.put(arr2[i], i);
            }
            int[] ans1 = Arrays.stream(arr1).filter(map::containsKey).boxed()
                    .sorted((x, y) -> map.get(x) - map.get(y)).mapToInt(Integer::intValue).toArray();
            int[] ans2 = Arrays.stream(arr1).filter(x -> !map.containsKey(x)).sorted().toArray();
            int[] ans = new int[arr1.length];
            System.arraycopy(ans1, 0, ans, 0, ans1.length);
            System.arraycopy(ans2, 0, ans, ans1.length, ans2.length);
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       