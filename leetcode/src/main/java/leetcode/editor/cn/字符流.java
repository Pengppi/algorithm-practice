/**
 * @Title: 1032.字符流
 * @TitleSlug: streamOfCharacters
 * @Author: Neo
 * @Date: 2023-03-24 13:52:05
 */
package leetcode.editor.cn;

import java.util.ArrayList;

public class 字符流 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 字符流().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class StreamChecker {

        private List<String> words;

        private List<Character> list = new ArrayList<>();

        public StreamChecker(String[] words) {
            this.words = new ArrayList<>(Arrays.asList(words));
        }

        public boolean query(char letter) {
            list.add(letter);
            for (String word : words) {
                int i = list.size() - 1;
                int j = word.length() - 1;
                if (i < j) {
                    continue;
                }
                while (i >= 0 && j >= 0 && list.get(i) == word.charAt(j)) {
                    i--;
                    j--;
                }
                if (j == -1) {
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * Your StreamChecker object will be instantiated and called as such:
     * StreamChecker obj = new StreamChecker(words);
     * boolean param_1 = obj.query(letter);
     */
    //leetcode submit region end(Prohibit modification and deletion)
}
