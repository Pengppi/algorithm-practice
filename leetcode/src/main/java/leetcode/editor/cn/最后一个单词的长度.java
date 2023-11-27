/**
 * @Title: 58.最后一个单词的长度
 * @TitleSlug: lengthOfLastWord
 * @Author: Neo
 * @Date: 2023-11-26 18:36:47
 */
package leetcode.editor.cn;

public class 最后一个单词的长度 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 最后一个单词的长度().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLastWord(String s) {
            char[] arr = s.trim().toCharArray();
            int n = arr.length;
            for (int i = n - 1; i >= 0; i--) {
                if (Character.isLetter(arr[i])) {
                    int j = i - 1;
                    while (j >= 0 && Character.isLetter(arr[j])) {
                        j--;
                    }
                    return i - j;
                }
            }
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       