/**
 * @Title: 2423.删除字符使频率相同
 * @TitleSlug: removeLetterToEqualizeFrequency
 * @Author: Neo
 * @Date: 2023-04-29 10:19:52
 */
package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class 删除字符使频率相同 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 删除字符使频率相同().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean equalFrequency(String word) {
            int alphabet[] = new int[26];
            for (char c : word.toCharArray()) {
                int i = c - 'a';
                alphabet[i]++;
            }

            for (int i = 0; i < alphabet.length; i++) {
                if (alphabet[i] == 0) {
                    continue;
                }
                alphabet[i]--;
                Set<Integer> set = new HashSet<>();
                for (int j = 0; j < alphabet.length; j++) {
                    if (alphabet[j] != 0) {
                        set.add(alphabet[j]);
                    }
                }
                if (set.size() == 1) {
                    return true;
                }
                alphabet[i]++;
            }
            return false;

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
        
       