/**
 * @Title: 443.压缩字符串
 * @TitleSlug: stringCompression
 * @Author: Neo
 * @Date: 2023-10-14 00:15:04
 */
package leetcode.editor.cn;

public class 压缩字符串 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 压缩字符串().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int compress(char[] chars) {
            int cur = 0;
            for (int i = 0; i < chars.length; ) {
                int j = i + 1, cnt = 1;
                while (j < chars.length && chars[j] == chars[i]) {
                    cnt++;
                    j++;
                }
                chars[cur++] = chars[i];
                if (cnt != 1) {
                    String num = String.valueOf(cnt);
                    for (int k = 0; k < num.length(); k++) {
                        chars[cur++] = num.charAt(k);
                    }
                }
                i = j;
            }
            return cur;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       