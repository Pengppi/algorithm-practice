/**
 * @Title: 1456.定长子串中元音的最大数目
 * @TitleSlug: maximumNumberOfVowelsInASubstringOfGivenLength
 * @Author: Neo
 * @Date: 2023-11-04 14:12:53
 */
package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;

public class 定长子串中元音的最大数目 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 定长子串中元音的最大数目().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxVowels(String s, int k) {
            HashSet<Character> set = new HashSet<>();
            set.addAll(Arrays.asList(new Character[]{'a', 'e', 'i', 'o', 'u'}));
            int cnt = 0;
            char[] charArray = s.toCharArray();
            for (int i = 0; i < k; i++) {
                if (set.contains(charArray[i])) {
                    cnt++;
                }
            }
            int ans = cnt;
            for (int i = k; i < charArray.length; i++) {
                if (set.contains(charArray[i - k])) {
                    cnt--;
                }
                if (set.contains(charArray[i])) {
                    cnt++;
                }
                ans = Math.max(ans, cnt);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       