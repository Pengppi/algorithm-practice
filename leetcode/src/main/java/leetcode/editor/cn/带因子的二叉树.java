/**
 * @Title: 823.带因子的二叉树
 * @TitleSlug: binaryTreesWithFactors
 * @Author: Neo
 * @Date: 2023-08-29 19:18:52
 */
package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 带因子的二叉树 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 带因子的二叉树().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numFactoredBinaryTrees(int[] arr) {
            Arrays.sort(arr);
            long ans = 0;
            long MOD = (long) 1e9 + 7;
            Map<Integer, Long> mp = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                long cnt = 1;
                for (int j = 0; j < i; j++) {
                    if (arr[i] % arr[j] != 0) {
                        continue;
                    }
                    int k = arr[i] / arr[j];
                    if (mp.containsKey(k)) {
                        cnt += (mp.get(arr[j]) * mp.get(k))%MOD;
                    }
                }
                mp.put(arr[i], cnt);
                ans += cnt;
            }
            return (int)(ans%MOD);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       