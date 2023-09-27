/**
 * @Title: 1333.餐厅过滤器
 * @TitleSlug: filterRestaurantsByVeganFriendlyPriceAndDistance
 * @Author: Neo
 * @Date: 2023-09-27 10:04:56
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class 餐厅过滤器 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 餐厅过滤器().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
            List<Integer> ans = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < restaurants.length; i++) {
                int[] rest = restaurants[i];
                if (veganFriendly == 1 && rest[2] != 1) {
                    continue;
                }
                if (rest[3] > maxPrice) {
                    continue;
                }
                if (rest[4] > maxDistance) {
                    continue;
                }
                list.add(i);
            }
            list.sort((a, b) -> (
                    restaurants[b][1] != restaurants[a][1] ?
                            restaurants[b][1] - restaurants[a][1]
                            : restaurants[b][0] - restaurants[a][0]
            ));
            for (Integer i : list) {
                ans.add(restaurants[i][0]);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       