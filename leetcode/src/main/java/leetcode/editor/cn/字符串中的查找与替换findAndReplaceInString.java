/**
 * @Title: 833.字符串中的查找与替换
 * @TitleSlug: findAndReplaceInString
 * @Author: Neo
 * @Date: 2024-04-27 23:30:51
 */
package leetcode.editor.cn;

import java.util.stream.IntStream;

public class 字符串中的查找与替换findAndReplaceInString {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 字符串中的查找与替换findAndReplaceInString().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
            int last = s.length();
            for (int i : IntStream.range(0, indices.length).boxed().sorted((a, b) -> (indices[b] - indices[a])).mapToInt(Integer::intValue).toArray()) {
                int idx = indices[i];
                if (idx != last && s.startsWith(sources[i], idx)) {
                    s = s.substring(0, idx) + targets[i] + s.substring(idx + sources[i].length());
                    last = idx;
                }
            }
            return s;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       