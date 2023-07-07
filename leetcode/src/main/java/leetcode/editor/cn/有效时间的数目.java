/**
 * @Title: 2437.有效时间的数目
 * @TitleSlug: numberOfValidClockTimes
 * @Author: Neo
 * @Date: 2023-05-09 21:06:49
 */
package leetcode.editor.cn;

public class 有效时间的数目 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 有效时间的数目().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countTime(String time) {
            int cnt = 1;
            int pos = time.indexOf("?");
            while (pos != -1) {
                char c;
                switch (pos) {
                    case 4:
                        return cnt * 10;
                    case 3:
                        cnt *= 6;
                        break;
                    case 1:
                         c = time.charAt(0);
                        if (c < '2') {
                            cnt *= 10;
                        } else {
                            cnt *= 4;
                        }
                        break;
                    case 0:
                         c = time.charAt(1);
                        if (c == '?') {
                            cnt *= 24;
                            pos = 1;
                        } else if (c > '3') {
                            cnt *= 2;
                        } else {
                            cnt *= 3;
                        }
                        break;
                }
                pos = time.indexOf("?", pos + 1);
            }
            return cnt;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
        
       