/**
 * @Title: 1419.数青蛙
 * @TitleSlug: minimumNumberOfFrogsCroaking
 * @Author: Neo
 * @Date: 2023-05-06 13:31:50
 */
package leetcode.editor.cn;

public class 数青蛙 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 数青蛙().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minNumberOfFrogs(String croakOfFrogs) {
            int[] cnt = new int[5];
            char[] cs = new char[]{'c', 'r', 'o', 'a', 'k'};
            for (char c : croakOfFrogs.toCharArray()) {
                for (int i = 0; i < cs.length; i++) {
                    if (cs[i] == c) {
                        if (i == 0) {
                            if (cnt[4] > 0) {
                                cnt[4]--;
                            }
                        } else {
                            if (--cnt[i - 1] < 0) {
                                return -1;
                            }
                        }
                        cnt[i]++;
                    }
                }
            }
            for (int i = 0; i < cnt.length - 1; i++) {
                if (cnt[i] > 0) {
                    return -1;
                }
            }
            return cnt[4];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
        
       