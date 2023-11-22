/**
 * @Title: 1410.HTML 实体解析器
 * @TitleSlug: htmlEntityParser
 * @Author: Neo
 * @Date: 2023-11-23 00:17:29
 */
package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class HTML实体解析器 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new HTML实体解析器().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String entityParser(String text) {
            Map<String, String> map = new HashMap<>();
            map.put("&quot;", "\"");
            map.put("&apos;", "'");
            map.put("&amp;", "&");
            map.put("&gt;", ">");
            map.put("&lt;", "<");
            map.put("&frasl;", "/");

            char[] arr = text.toCharArray();
            int i = 0, n = arr.length;
            StringBuilder ans = new StringBuilder();
            while (i < n) {
                if (arr[i] == '&') {
                    int j = i + 1;
                    StringBuilder builder = new StringBuilder("&");
                    while (j < n && Character.isLowerCase(arr[j])) {
                        builder.append(arr[j++]);
                    }
                    if (j >= n) {
                        ans.append(builder);
                        break;
                    }
                    if (arr[j] == '&') {
                        i = j;
                        ans.append(builder);
                    } else if (arr[j] == ';') {
                        builder.append(arr[j]);
                        String k = builder.toString();
                        if (map.containsKey(k)) {
                            ans.append(map.get(k));
                        } else {
                            ans.append(builder);
                        }
                        i = j + 1;
                    } else {
                        builder.append(arr[j]);
                        ans.append(builder);
                        i = j + 1;
                    }
                } else {
                    ans.append(arr[i++]);
                }
            }
            return ans.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       