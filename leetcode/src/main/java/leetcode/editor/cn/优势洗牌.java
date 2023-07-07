/**
 * @Title: 870.优势洗牌
 * @TitleSlug: AdvantageShuffle
 * @Author: Neo
 * @Date: 2022-10-08 16:13:47
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 优势洗牌 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 优势洗牌().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] advantageCount(int[] nums1, int[] nums2) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < nums1.length; i++) {
                list.add(nums1[i]);
            }
            Collections.sort(list);
            int res[] = new int[nums1.length];
            for (int i = 0; i < nums2.length; i++) {
                int idx = Collections.binarySearch(list, nums2[i] + 1);
                if (idx < 0) {
                    idx = -idx - 1;
                }
                if (idx == list.size()) {
                    idx = 0;
                }
                res[i] = list.get(idx);
                list.remove(idx);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
