/**
 * @Title: 2559.统计范围内的元音字符串数
 * @TitleSlug: countVowelStringsInRanges
 * @Author: Neo
 * @Date: 2023-06-02 00:34:48
 */
package leetcode.editor.cn;

public class 统计范围内的元音字符串数 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 统计范围内的元音字符串数().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] vowelStrings(String[] words, int[][] queries) {
            int n = words.length;
            Set<Character> set = new HashSet<>();
            set.add('a');
            set.add('e');
            set.add('i');
            set.add('o');
            set.add('u');
            int[] sum = new int[n + 1];
            for (int i = 0; i < n; i++) {
                char[] cc = words[i].toCharArray();
                sum[i + 1] += sum[i];
                if (set.contains(cc[0]) && set.contains(cc[cc.length - 1])) {
                    sum[i + 1]++;
                }
            }
            int[] ans = new int[queries.length];
            for (int i = 0; i < queries.length; i++) {
                int l = queries[i][0], r = queries[i][1];
                ans[i] = sum[r + 1] - sum[l];
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       