/**
 * @Title: 2609.最长平衡子字符串
 * @TitleSlug: findTheLongestBalancedSubstringOfABinaryString
 * @Author: Neo
 * @Date: 2023-11-08 00:21:09
 */
package leetcode.editor.cn;

public class 最长平衡子字符串 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 最长平衡子字符串().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findTheLongestBalancedSubstring(String s) {
            char[] arr = s.toCharArray();
            int n = arr.length, ans = 0;
            for (int i = 0; i < n; ) {
                int cnt0 = 0, cnt1 = 0;
                while (i < n && arr[i] == '0') {
                    i++;
                    cnt0++;
                }
                while (i < n && arr[i] == '1') {
                    i++;
                    cnt1++;
                }
                ans = Math.max(ans, Math.min(cnt0, cnt1));
            }
            return ans * 2;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       