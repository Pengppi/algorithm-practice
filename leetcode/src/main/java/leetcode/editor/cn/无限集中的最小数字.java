/**
 * @Title: 2336.无限集中的最小数字
 * @TitleSlug: smallestNumberInInfiniteSet
 * @Author: Neo
 * @Date: 2023-11-15 15:08:13
 */
package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class 无限集中的最小数字 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 无限集中的最小数字().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class SmallestInfiniteSet {

        private Set<Integer> set;
        private int mn;

        public SmallestInfiniteSet() {
            set = new HashSet<>();
            mn = 1;
        }

        public int popSmallest() {
            int res = mn;
            set.add(mn);
            while (set.contains(mn)) {
                mn++;
            }
            return res;
        }

        public void addBack(int num) {
            if (set.contains(num)) {
                set.remove(num);
                mn = Math.min(mn, num);
            }
        }
    }

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
        
       