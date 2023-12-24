/**
 * @Title: 1954.收集足够苹果的最小花园周长
 * @TitleSlug: minimumGardenPerimeterToCollectEnoughApples
 * @Author: Neo
 * @Date: 2023-12-24 00:17:10
 */
package leetcode.editor.cn;

public class 收集足够苹果的最小花园周长 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 收集足够苹果的最小花园周长().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //一排有n*(n+1)/2个苹果（求和公式）
        //右上角部分（即总的四分之一）有 n*(n+1)排
        //所以边长为 n 的区域总共有 4 * n*(n+1) * n*(n+1)/2
        public long minimumPerimeter(long neededApples) {
            long n = 1;
            while (2 * n * (n + 1) * (2 * n + 1) < neededApples) {
                n++;
            }
            return n * 8;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       