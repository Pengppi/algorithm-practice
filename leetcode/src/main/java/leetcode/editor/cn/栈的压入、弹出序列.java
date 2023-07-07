/**
 * @Title: 剑指 Offer 31.栈的压入、弹出序列
 * @TitleSlug: zhanDeYaRuDanChuXuLieLcof
 * @Author: Neo
 * @Date: 2023-05-25 11:13:50
 */
package leetcode.editor.cn;

import java.util.Deque;

public class 栈的压入、弹出序列{
public static void main(String[]args){
        //测试代码
        Solution solution=new 栈的压入、弹出序列().new Solution();
        }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0, j = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
        
       