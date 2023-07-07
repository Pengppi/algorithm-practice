/**
 * @Title: 剑指 Offer 11.旋转数组的最小数字
 * @TitleSlug: xuanZhuanShuZuDeZuiXiaoShuZiLcof
 * @Author: Neo
 * @Date: 2023-04-28 12:54:57
 */
package leetcode.editor.cn;
public class 旋转数组的最小数字{
public static void main(String[] args) {
        //测试代码
        Solution solution = new 旋转数组的最小数字().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length-1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (numbers[mid] > numbers[right]) left = mid + 1;
            else if (numbers[mid] < numbers[right]) right = mid;
            else right--;
        }
        return numbers[left];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
        
       