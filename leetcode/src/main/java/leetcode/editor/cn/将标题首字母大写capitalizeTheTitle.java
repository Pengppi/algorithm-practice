/**
 * @Title: 2129.将标题首字母大写
 * @TitleSlug: capitalizeTheTitle
 * @Author: Neo
 * @Date: 2024-03-11 00:33:41
 */
package leetcode.editor.cn;

import java.util.Arrays;
import java.util.stream.Collectors;

public class 将标题首字母大写capitalizeTheTitle {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 将标题首字母大写capitalizeTheTitle().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String capitalizeTitle(String title) {
            return Arrays.stream(title.toLowerCase().split(" "))
                    .map(s -> s.length() <= 2 ? s :
                            Character.toUpperCase(s.charAt(0)) + s.substring(1))
                    .collect(Collectors.joining(" "));
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       