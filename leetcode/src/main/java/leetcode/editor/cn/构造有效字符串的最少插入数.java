/**
 * @Title: 2645.构造有效字符串的最少插入数
 * @TitleSlug: minimumAdditionsToMakeValidString
 * @Author: Neo
 * @Date: 2024-01-11 08:49:26
 */
package leetcode.editor.cn;

public class 构造有效字符串的最少插入数 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 构造有效字符串的最少插入数().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int addMinimum(String word) {
            char[] arr = word.toCharArray();
            int n = arr.length;
            int[] f = new int[n + 1];
            for (int i = 0; i < n; i++) {
                f[i + 1] = f[i] + 2;
                if (i > 0 && arr[i] > arr[i - 1]) {
                    f[i + 1] = f[i] - 1;
                }
            }
            return f[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       