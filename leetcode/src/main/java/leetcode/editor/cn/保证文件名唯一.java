/**
 * @Title: 1487.保证文件名唯一
 * @TitleSlug: MakingFileNamesUnique
 * @Author: Neo
 * @Date: 2023-03-03 15:56:03
 */
package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class 保证文件名唯一 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 保证文件名唯一().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String[] getFolderNames(String[] names) {
            int n = names.length;
            String[] ans = new String[n];
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                String name = names[i];
                if (!map.containsKey(name)) {
                    ans[i] = name;
                    map.put(name, 1);
                } else {
                    int k = map.get(name);
                    while (map.containsKey(addSuffix(name, k))) {
                        k++;
                    }
                    String res = addSuffix(name, k);
                    ans[i] = res;
                    map.put(name, k + 1);
                    map.put(res, 1);
                }
            }
            return ans;
        }

        String addSuffix(String name, int k) {
            return name + "(" + k + ")";
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
