/**
 * @Title: 2475.数组中不等三元组的数目
 * @TitleSlug: numberOfUnequalTripletsInArray
 * @Author: Neo
 * @Date: 2023-06-13 10:51:39
 */
package leetcode.editor.cn;

import java.util.HashSet;

public class 数组中不等三元组的数目 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 数组中不等三元组的数目().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int unequalTriplets(int[] nums) {
            int n = nums.length;
            int ans=0;
            for (int i = 0; i < n - 2; i++) {
                for (int j = i + 1; j < n - 1; j++) {
                    for (int k = j + 1; k < n; k++) {
                        if(nums[i]==nums[j]||nums[i]==nums[k]||nums[j]==nums[k]){
                            continue;
                        }
                        ans++;
                    }
                }
            }
            return ans;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       