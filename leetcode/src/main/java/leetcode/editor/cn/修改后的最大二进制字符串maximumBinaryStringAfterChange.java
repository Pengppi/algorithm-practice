/**
 * @Title: 1702.修改后的最大二进制字符串
 * @TitleSlug: maximumBinaryStringAfterChange
 * @Author: Neo
 * @Date: 2024-04-10 00:32:02
 */
package leetcode.editor.cn;

import java.util.Arrays;
import java.util.stream.IntStream;

public class 修改后的最大二进制字符串maximumBinaryStringAfterChange {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 修改后的最大二进制字符串maximumBinaryStringAfterChange().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String maximumBinaryString2(String binary) {
            char[] arr = binary.toCharArray();
            int n = arr.length;
            for (int i = 0, j = 0; i < n - 1; i++) {
                if (arr[i] == '0') {
                    while (j <= i || j < n && arr[j] == '1') {
                        j++;
                    }
                    if (j == n) {
                        break;
                    }
                    arr[j] = '1';
                    arr[i + 1] = '0';
                    arr[i] = '1';
                }
            }
            return new String(arr);
        }
        
        public String maximumBinaryString(String binary) {
            char[] arr = binary.toCharArray();
            int start = IntStream.range(0, arr.length).filter(i -> arr[i] == '0').findFirst().orElse(-1);
            if (start == -1) {
                return binary;
            }
            int len = (int) IntStream.range(0, arr.length).filter(i -> arr[i] == '0').count();
            Arrays.fill(arr, '1');
            arr[start + len - 1] = '0';
            return new String(arr);
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       