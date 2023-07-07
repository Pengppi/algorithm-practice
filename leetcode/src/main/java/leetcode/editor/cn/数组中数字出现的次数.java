/**
 * @Title: 剑指 Offer 56 - I.数组中数字出现的次数
 * @TitleSlug: shuZuZhongShuZiChuXianDeCiShuLcof
 * @Author: Neo
 * @Date: 2023-05-30 10:57:23
 */
package leetcode.editor.cn;

public class 数组中数字出现的次数 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 数组中数字出现的次数().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] singleNumbers(int[] nums) {
            int z = 0, x = 0, y = 0;
            for (int num : nums) {
                z ^= num;
            }
            int m = 1;
            while ((z & m) == 0) {
                m <<= 1;
            }
            for (int num : nums) {
                if ((num & m) != 0) {
                    x ^= num;
                } else {
                    y ^= num;
                }
            }
            return new int[]{x, y};

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       