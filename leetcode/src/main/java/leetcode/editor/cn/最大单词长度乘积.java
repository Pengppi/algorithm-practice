/**
 * @Title: 318.最大单词长度乘积
 * @TitleSlug: maximumProductOfWordLengths
 * @Author: Neo
 * @Date: 2023-11-06 15:02:34
 */
package leetcode.editor.cn;

import java.util.Arrays;

public class 最大单词长度乘积 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 最大单词长度乘积().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProduct(String[] words) {
            int n = words.length;
            int[] stat = new int[n];
            Arrays.sort(words, (a, b) -> (b.length() - a.length()));
            int ans = 0;
            for (int i = 0; i < n; i++) {
                char[] ca = words[i].toCharArray();
                int cur = 0;
                for (char c : ca) {
                    int x = c - 'a';
                    cur |= (1 << x);
                }
                stat[i] = cur;
                for (int j = 0; j < i; j++) {
                    if (words[j].length() * words[i].length() < ans) {
                        break;
                    }
                    if ((stat[i] & stat[j]) == 0) {
                        ans = Math.max(ans, words[i].length() * words[j].length());
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       