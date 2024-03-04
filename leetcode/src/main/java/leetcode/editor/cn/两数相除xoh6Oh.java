/**
 * @Title: LCR 001.两数相除
 * @TitleSlug: xoh6Oh
 * @Author: Neo
 * @Date: 2024-03-04 20:56:00
 */
package leetcode.editor.cn;

public class 两数相除xoh6Oh {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 两数相除xoh6Oh().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int divide(int a, int b) {
            if (a == Integer.MIN_VALUE) {
                if (b == 1) {
                    return Integer.MIN_VALUE;
                } else if (b == -1) {
                    return Integer.MAX_VALUE;
                }
            }
            if (b == Integer.MIN_VALUE) {
                return a == Integer.MIN_VALUE ? 1 : 0;
            }
            if (a == 0) {
                return 0;
            }
            boolean flg = false;
            if (a > 0) {
                a = -a;
                flg = !flg;
            }
            if (b > 0) {
                b = -b;
                flg = !flg;
            }
            int l = 1, r = Integer.MAX_VALUE, ans = 0;
            while (l <= r) {
                int m = l + ((r - l) >> 1);
                if (check(a, b, m)) {
                    ans = m;
                    if (m == Integer.MAX_VALUE) {
                        break;
                    }
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
            return flg ? -ans : ans;
        }
        
        private boolean check(int a, int b, int m) {
            int res = 0, add = b;
            while (m != 0) {
                if ((m & 1) != 0) {
                    if (res < a - add) {
                        return false;
                    }
                    res += add;
                }
                if (m != 1) {
                    if (add < a - add) {
                        return false;
                    }
                    add += add;
                }
                m >>= 1;
            }
            return true;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       