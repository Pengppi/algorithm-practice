/**
 * @Title: 2454.下一个更大元素 IV
 * @TitleSlug: nextGreaterElementIv
 * @Author: Neo
 * @Date: 2023-12-12 01:16:00
 */
package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;

public class 下一个更大元素IV {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 下一个更大元素IV().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] secondGreaterElement(int[] nums) {
            int n = nums.length;
            int[] ans = new int[n];
            Arrays.fill(ans, -1);
            Deque<Integer> st = new ArrayDeque<>();
            PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
            for (int i = 0; i < n; i++) {
                while (!q.isEmpty() && q.peek()[0] < nums[i]) {
                    ans[q.poll()[1]] = nums[i];
                }
                while (!st.isEmpty() && nums[st.peek()] < nums[i]) {
                    int x = st.pop();
                    q.offer(new int[]{nums[x], x});
                }
                st.push(i);
            }
            return ans;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       