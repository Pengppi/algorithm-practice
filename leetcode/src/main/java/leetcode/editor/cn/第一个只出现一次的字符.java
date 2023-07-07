/**
 * @Title: 剑指 Offer 50.第一个只出现一次的字符
 * @TitleSlug: diYiGeZhiChuXianYiCiDeZiFuLcof
 * @Author: Neo
 * @Date: 2023-06-02 15:38:42
 */
package leetcode.editor.cn;

public class 第一个只出现一次的字符 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 第一个只出现一次的字符().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public char firstUniqChar(String s) {
            int[] cnt = new int[26];
            for (char c : s.toCharArray()) {
                cnt[c - 'a']++;
            }
            char ans = ' ';
            for (char c : s.toCharArray()) {
                if (cnt[c - 'a'] == 1) {
                    ans = c;
                    break;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       