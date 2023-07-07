/**
 * @Title: 1662.检查两个字符串数组是否相等 
 * @TitleSlug: CheckIfTwoStringArraysAreEquivalent
 * @Author: Neo
 * @Date: 2022-11-02 08:54:46
 */
package leetcode.editor.cn;
public class 检查两个字符串数组是否相等{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 检查两个字符串数组是否相等().new Solution();
    }
      
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder sb1=new StringBuilder();
        StringBuilder sb2=new StringBuilder();
        for (String s : word1) {
            sb1.append(s);
        }
        for (String s : word2) {
            sb2.append(s);
        }
        return sb1.toString().equals(sb2.toString());
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
