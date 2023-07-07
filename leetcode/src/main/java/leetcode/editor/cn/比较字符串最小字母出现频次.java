/**
 * @Title: 1170.比较字符串最小字母出现频次
 * @TitleSlug: compareStringsByFrequencyOfTheSmallestCharacter
 * @Author: Neo
 * @Date: 2023-06-10 00:18:03
 */
package leetcode.editor.cn;

import java.util.Arrays;

public class 比较字符串最小字母出现频次 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 比较字符串最小字母出现频次().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] numSmallerByFrequency(String[] queries, String[] words) {
            int[] fw = new int[words.length];
            for (int i = 0; i < words.length; i++) {
                fw[i] = f(words[i]);
            }
            Arrays.sort(fw);
            int[] ans = new int[queries.length];
            for (int i = 0; i < queries.length; i++) {
                int t = f(queries[i]);
                int cnt = lower_bound(fw, t + 1);
                if (cnt < fw.length) {
                    ans[i] = fw.length - cnt;
                }
            }
            return ans;

        }

        private int f(String s) {
            char t = 'z';
            int res = 0;
            for (char c : s.toCharArray()) {
                if (c < t) {
                    t = c;
                    res = 1;
                } else if (c == t) {
                    res++;
                }
            }
            return res;
        }

        private int lower_bound(int[] arr, int t) {
            int l = 0, r = arr.length - 1;
            while (l <= r) {
                int m = (l + r) >> 1;
                if (arr[m] < t) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
            return l;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       