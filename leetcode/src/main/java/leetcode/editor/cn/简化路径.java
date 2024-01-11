/**
 * @Title: 71.简化路径
 * @TitleSlug: simplifyPath
 * @Author: Neo
 * @Date: 2024-01-11 13:22:15
 */
package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class 简化路径 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 简化路径().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String simplifyPath(String path) {
            String[] f = path.split("/");
            int n = f.length;
            Deque<String> st = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                if (f[i].isEmpty() || ".".equals(f[i])) {
                    continue;
                }
                if ("..".equals(f[i])) {
                    if (!st.isEmpty()) {
                        st.pop();
                    }
                } else {
                    st.push(f[i]);
                }
            }
            StringBuilder sb = new StringBuilder();
            while (!st.isEmpty()) {
                sb.append("/").append(st.pollLast());
            }
            return sb.length() == 0 ? "/" : sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       