/**
 * @Title: 722.删除注释
 * @TitleSlug: removeComments
 * @Author: Neo
 * @Date: 2023-08-03 10:57:13
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class 删除注释 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 删除注释().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> removeComments(String[] source) {
            List<String> ans = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            boolean flg = false;
            for (String line : source) {
                for (int i = 0; i < line.length(); i++) {
                    if (flg) {
                        if (i + 1 < line.length() && line.charAt(i) == '*' && line.charAt(i + 1) == '/') {
                            flg = false;
                            i++;
                        }
                    } else {
                        if (i + 1 < line.length() && line.charAt(i) == '/' && line.charAt(i + 1) == '*') {
                            flg = true;
                            i++;
                        } else if (i + 1 < line.length() && line.charAt(i) == '/' && line.charAt(i + 1) == '/') {
                            break;
                        } else {
                            sb.append(line.charAt(i));
                        }
                    }
                }
                if (!flg && sb.length() > 0) {
                    ans.add(sb.toString());
                    sb.setLength(0);
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       