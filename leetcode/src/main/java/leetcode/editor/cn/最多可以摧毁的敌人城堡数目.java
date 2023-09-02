/**
 * @Title: 2511.最多可以摧毁的敌人城堡数目
 * @TitleSlug: maximumEnemyFortsThatCanBeCaptured
 * @Author: Neo
 * @Date: 2023-09-02 10:43:34
 */
package leetcode.editor.cn;

public class 最多可以摧毁的敌人城堡数目 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 最多可以摧毁的敌人城堡数目().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int captureForts(int[] forts) {
            int ans = 0, n = forts.length;
            int cnt = 0;
            boolean flg = false;
            for (int i = 0; i < n; i++) {
                if (forts[i] == -1) {
                    flg = true;
                    cnt = 0;
                } else if (forts[i] == 0) {
                    if (flg) {
                        cnt++;
                    }
                } else {
                    ans = Math.max(ans, cnt);
                    flg = false;
                    cnt = 0;
                }
            }
            cnt = 0;
            flg=false;
            for (int i = n - 1; i >= 0; i--) {
                if (forts[i] == -1) {
                    flg = true;
                    cnt = 0;
                } else if (forts[i] == 0) {
                    if (flg) {
                        cnt++;
                    }
                } else {
                    ans = Math.max(ans, cnt);
                    flg = false;
                    cnt = 0;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       