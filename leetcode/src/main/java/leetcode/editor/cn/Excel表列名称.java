/**
 * @Title: 168.Excel表列名称
 * @TitleSlug: ExcelSheetColumnTitle
 * @Author: Neo
 * @Date: 2022-10-26 12:04:08
 */
package leetcode.editor.cn;

public class Excel表列名称 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new Excel表列名称().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String convertToTitle(int columnNumber) {
            StringBuilder sb = new StringBuilder();
            while (columnNumber > 0) {
                columnNumber--;
                sb.append((char) (columnNumber % 26 + 'A'));
                columnNumber /= 26;
            }
            return sb.reverse().toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
