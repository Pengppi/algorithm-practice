/**
 * @Title: 299.猜数字游戏
 * @TitleSlug: bullsAndCows
 * @Author: Neo
 * @Date: 2024-03-10 00:14:04
 */
package leetcode.editor.cn;

public class 猜数字游戏bullsAndCows {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 猜数字游戏bullsAndCows().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String getHint(String secret, String guess) {
            int bulls = 0;
            int[] numOfSecret = new int[10];
            int[] numOfGuess = new int[10];
            for (int i = 0; i < secret.length(); i++) {
                if (secret.charAt(i) == guess.charAt(i)) {
                    bulls++;
                } else {
                    numOfSecret[secret.charAt(i) - '0']++;
                    numOfGuess[guess.charAt(i) - '0']++;
                }
            }
            int cows = 0;
            for (int i = 0; i < 10; i++) {
                if (numOfSecret[i] > 0 && numOfGuess[i] > 0) {
                    cows += Math.min(numOfSecret[i], numOfGuess[i]);
                }
            }
            return bulls + "A" + cows + "B";
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       