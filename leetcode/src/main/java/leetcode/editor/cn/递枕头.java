/**
 * @Title: 2582.递枕头
 * @TitleSlug: passThePillow
 * @Author: Neo
 * @Date: 2023-09-26 16:24:17
 */
package leetcode.editor.cn;

public class 递枕头 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 递枕头().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int passThePillow(int n, int time) {
            time %= (n - 1)*2;
            if (time >= n) {
                return n - (time - (n - 1));
            }else{
                return 1+time;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       