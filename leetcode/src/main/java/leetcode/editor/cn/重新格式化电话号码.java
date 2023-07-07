/**
 * @Title: 1694.重新格式化电话号码
 * @TitleSlug: ReformatPhoneNumber
 * @Author: Neo
 * @Date: 2022-10-01 20:09:13
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class 重新格式化电话号码 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 重新格式化电话号码().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reformatNumber(String number) {
            List<String> list = new ArrayList<>();
            String str = "";
            for (char c : number.toCharArray()) {
                if (Character.isDigit(c)) {
                    str += c;
                }
                if (str.length() == 3) {
                    list.add(str);
                    str = "";
                }
            }
            if (list.size() == 0) {
                return str;
            }
            StringBuilder ans = new StringBuilder();
            for (int i = 0; i < list.size() - 1; i++) {
                ans.append(list.get(i)).append("-");
            }
            if (str.length() == 2) {
                ans.append(list.get(list.size() - 1)).append("-");
                ans.append(str);
            } else if (str.length() == 1) {
                String tail = list.get(list.size() - 1) + str;
                ans.append(tail.substring(0, 2)).append("-");
                ans.append(tail.substring(2));
            } else {
                ans.append(list.get(list.size() - 1));
            }
            return ans.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
