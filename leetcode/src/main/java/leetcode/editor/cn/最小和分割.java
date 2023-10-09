/**
 * @Title: 2578.最小和分割
 * @TitleSlug: splitWithMinimumSum
 * @Author: Neo
 * @Date: 2023-10-09 14:44:07
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 最小和分割 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 最小和分割().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int splitNum(int num) {
            List<Integer> list = new ArrayList<>();
            while (num > 0) {
                list.add(num % 10);
                num /= 10;
            }
            Collections.sort(list);
            int a = 0, b = 0;
            for (int i = 0; i < list.size(); i += 2) {
                int j = i + 1;
                a = a * 10 + list.get(i);
                if (j < list.size()) {
                    b = b * 10 + list.get(j);
                }
            }
            return a+b;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       