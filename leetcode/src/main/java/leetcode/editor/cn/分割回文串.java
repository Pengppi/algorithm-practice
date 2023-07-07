/**
 * @Title: 131.分割回文串
 * @TitleSlug: palindromePartitioning
 * @Author: Neo
 * @Date: 2023-06-09 17:49:53
 */
package leetcode.editor.cn;

public class 分割回文串 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 分割回文串().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<String>> ans;

        public List<List<String>> partition(String s) {
            ans = new ArrayList<>();
            dfs(s, 0, new ArrayList<>());
            return ans;
        }

        private void dfs(String s, int i, List<String> path) {
            if (i == s.length()) {
                ans.add(new ArrayList<>(path));
                return;
            }
            for (int j = i; j < s.length(); j++) {
                if (isPalindrome(s, i, j)) {
                    path.add(s.substring(i, j + 1));
                    dfs(s, j + 1, path);
                    path.remove(path.size() - 1);
                }
            }
        }

        private boolean isPalindrome(String s, int i, int j) {
            while (i < j) {
                if (s.charAt(i++) != s.charAt(j--)) return false;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       