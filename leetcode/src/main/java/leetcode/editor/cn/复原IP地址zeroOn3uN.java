/**
 * @Title: LCR 087.复原 IP 地址
 * @TitleSlug: zeroOn3uN
 * @Author: Neo
 * @Date: 2024-03-22 19:49:58
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class 复原IP地址zeroOn3uN {
    public static void main(String[] args) {
        // 测试代码
        Solution solution = new 复原IP地址zeroOn3uN().new Solution();
        solution.restoreIpAddresses("010010");
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<String> ans = new ArrayList<>();
        char[] arr;
        
        public List<String> restoreIpAddresses(String s) {
            arr = s.toCharArray();
            backTrack(0, new ArrayList<>());
            return ans;
        }
        
        private void backTrack(int i, ArrayList<String> list) {
            if (list.size() == 4 && i == arr.length) {
                ans.add(String.join(".", list));
            } else if (list.size() == 4 || i == arr.length) {
            } else if (arr[i] == '0') {
                list.add("0");
                backTrack(i + 1, list);
                list.remove(list.size() - 1);
            } else {
                int num = 0;
                for (int j = i; j < Math.min(i + 3, arr.length); j++) {
                    num = num * 10 + arr[j] - '0';
                    if (num > 255) {
                        break;
                    }
                    list.add(String.valueOf(num));
                    backTrack(j + 1, list);
                    list.remove(list.size() - 1);
                }
            }
        }
    }
// leetcode submit region end(Prohibit modification and deletion)
    
}
       