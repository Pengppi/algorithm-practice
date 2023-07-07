/**
 * @Title: 2469.温度转换
 * @TitleSlug: convertTheTemperature
 * @Author: Neo
 * @Date: 2023-03-21 14:46:48
 */
package leetcode.editor.cn;

public class 温度转换 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 温度转换().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double[] convertTemperature(double celsius) {
            double kelvin = celsius + 273.15;
            double fahrenheit = celsius * 1.80 + 32.00;
            return new double[]{kelvin, fahrenheit};
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}
