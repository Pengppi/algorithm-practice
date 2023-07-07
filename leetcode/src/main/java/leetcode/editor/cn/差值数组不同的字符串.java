/**
 * @Title: 2451.差值数组不同的字符串
 * @TitleSlug: oddStringDifference
 * @Author: Neo
 * @Date: 2023-05-25 10:44:38
 */
package leetcode.editor.cn;

public class 差值数组不同的字符串 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 差值数组不同的字符串().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String oddString(String[] words) {
            int m = words.length;
            int n = words[0].length();

            for (int i = 0; i < n - 1; i++) {
                int diff = words[0].charAt(i + 1) - words[0].charAt(i);
                for (int j = 1; j < m; j++) {
                    if (words[j].charAt(i + 1) - words[j].charAt(i) != diff) {
                        if (j == 1) {
                            return words[2].charAt(i + 1) - words[2].charAt(i) == diff ? words[1] : words[0];
                        } else {
                            return words[j];
                        }
                    }
                }
            }
            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       