/**
 * @Title: 剑指 Offer 48.最长不含重复字符的子字符串
 * @TitleSlug: zuiChangBuHanZhongFuZiFuDeZiZiFuChuanLcof
 * @Author: Neo
 * @Date: 2023-06-13 13:59:44
 */
package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class 最长不含重复字符的子字符串 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 最长不含重复字符的子字符串().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            int ans = 0;
            Deque<Character> d = new ArrayDeque<>();
            for (char c : s.toCharArray()) {
                while (!d.isEmpty() && d.contains(c)) {
                    d.pollFirst();
                }
                d.addLast(c);
                ans=Math.max(ans,d.size());
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       