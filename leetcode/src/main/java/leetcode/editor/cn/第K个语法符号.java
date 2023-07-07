/**
 * @Title: 779.第K个语法符号
 * @TitleSlug: KThSymbolInGrammar
 * @Author: Neo
 * @Date: 2022-10-20 19:42:43
 */
package leetcode.editor.cn;

public class 第K个语法符号 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 第K个语法符号().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int kthGrammar(int n, int k) {
            if (k == 1) {
                return 0;
            }
            if (k > (1 << (n - 2))) {
                return 1 ^ kthGrammar(n - 1, k - (1 << (n - 2)));
            }
            return kthGrammar(n - 1, k);
        }

    }

//leetcode submit region end(Prohibit modification and deletion)

}
