/**
 * @Title: 1157.子数组中占绝大多数的元素
 * @TitleSlug: onlineMajorityElementInSubarray
 * @Author: Neo
 * @Date: 2023-04-16 16:31:29
 */
package leetcode.editor.cn;

import java.util.*;

public class 子数组中占绝大多数的元素 {
    public static void main(String[] args) {
        //测试代码
        MajorityChecker solution = new 子数组中占绝大多数的元素().new MajorityChecker();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MajorityChecker {
        static final int K = 20;
        int[] arr;
        Map<Integer, List<Integer>> loc;
        Random random;

        public MajorityChecker(int[] arr) {
            loc = new HashMap<>();
            this.arr = arr;
            random = new Random();
            for (int i = 0; i < arr.length; i++) {
                int x = arr[i];
                loc.putIfAbsent(x, new ArrayList<Integer>());
                loc.get(x).add(i);
            }
        }

        public int query(int left, int right, int threshold) {
            int len = right - left + 1;
            for (int i = 0; i < K; i++) {
                int t = arr[left + random.nextInt(len)];
                List<Integer> pos = loc.get(t);
                int cnt = searchEnd(pos, right) - searchStart(pos, left);
                if (cnt >= threshold) {
                    return t;
                } else if (cnt * 2 >= len) {
                    return -1;
                }
            }
            return -1;
        }

        public int searchStart(List<Integer> pos, int t) {
            int l = 0, r = pos.size();
            while (l < r) {
                int m = l + (r - l) / 2;
                if (pos.get(m) >= t) {
                    r = m;
                } else {
                    l = m + 1;
                }
            }
            return l;
        }

        public int searchEnd(List<Integer> pos, int t) {
            int l = 0, r = pos.size();
            while (l < r) {
                int m = l + (r - l) / 2;
                if (pos.get(m) > t) {
                    r = m;
                } else {
                    l = m + 1;
                }
            }
            return l;
        }
    }

    /**
     * Your MajorityChecker object will be instantiated and called as such:
     * MajorityChecker obj = new MajorityChecker(arr);
     * int param_1 = obj.query(left,right,threshold);
     */
    //leetcode submit region end(Prohibit modification and deletion)
}