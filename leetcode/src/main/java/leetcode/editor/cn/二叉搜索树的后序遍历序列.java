/**
 * @Title: 剑指 Offer 33.二叉搜索树的后序遍历序列
 * @TitleSlug: erChaSouSuoShuDeHouXuBianLiXuLieLcof
 * @Author: Neo
 * @Date: 2023-07-07 16:57:43
 */
package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class 二叉搜索树的后序遍历序列 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 二叉搜索树的后序遍历序列().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean verifyPostorder(int[] postorder) {
            int n = postorder.length;
            Deque<Integer> d = new ArrayDeque<>();
            int rt = Integer.MAX_VALUE;
            for (int i = n - 1; i >= 0; i--) {
                if (postorder[i] > rt) {
                    return false;
                }
                while (!d.isEmpty() && d.peek() > postorder[i]) {
                    rt = d.poll();
                }
                d.push(postorder[i]);
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       