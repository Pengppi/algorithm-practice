/**
 * @Title: 2418.按身高排序
 * @TitleSlug: sortThePeople
 * @Author: Neo
 * @Date: 2023-04-25 09:33:47
 */
package leetcode.editor.cn;

import java.util.TreeMap;

public class 按身高排序 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 按身高排序().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String[] sortPeople(String[] names, int[] heights) {
            Map<Integer, String> map = new TreeMap<>((a,b)->(b.compareTo(a)));
            for (int i = 0; i < names.length; i++) {
                map.put(heights[i], names[i]);
            }
            String[] ans = map.values().toArray(new String[0]);
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
        
       