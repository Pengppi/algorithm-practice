/**
 * @Title: 1073.负二进制数相加
 * @TitleSlug: addingTwoNegabinaryNumbers
 * @Author: Neo
 * @Date: 2023-05-18 00:21:01
 */
package leetcode.editor.cn;


import java.util.ArrayList;
import java.util.LinkedList;

public class 负二进制数相加 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 负二进制数相加().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] addNegabinary(int[] arr1, int[] arr2) {
            int n1 = arr1.length, n2 = arr2.length;
            int i1 = n1 - 1, i2 = n2 - 1;
            int carry = 0;
            List<Integer> list = new ArrayList<>();
            while (i1 >= 0 || i2 >= 0 || carry != 0) {
                int cur = carry;
                if (i1 >= 0) {
                    cur += arr1[i1--];
                }
                if (i2 >= 0) {
                    cur += arr2[i2--];
                }
                if (cur >= 2) {
                    list.add(cur - 2);
                    carry = -1;
                } else if (cur >= 0) {
                    list.add(cur);
                    carry = 0;
                } else {
                    list.add(1);
                    carry = 1;
                }
            }
            while (list.size() > 1 && list.get(list.size() - 1) == 0) {
                list.remove(list.size() - 1);
            }
            int n = list.size();
            int[] ans = new int[n];
            for (int i = n - 1; i >= 0; i--) {
                ans[n - 1 - i] = list.get(i);
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
        
       