/**
 * @Title: 2276.统计区间中的整数数目
 * @TitleSlug: countIntegersInIntervals
 * @Author: Neo
 * @Date: 2023-12-16 00:26:28
 */
package leetcode.editor.cn;

public class 统计区间中的整数数目 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 统计区间中的整数数目().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class CountIntervals {
        CountIntervals left, right;
        int l, r, cnt;

        public CountIntervals(int l, int r) {
            this.l = l;
            this.r = r;
        }

        public CountIntervals() {
            l = 1;
            r = (int) 1e9;
        }

        public void add(int L, int R) {
            if (cnt == r - l + 1) {
                return;
            }
            if (L <= l && r <= R) {
                cnt = r - l + 1;
                return;
            }
            int mid = (l + r) / 2;
            if (left == null) {
                left = new CountIntervals(l, mid);
            }
            if (right == null) {
                right = new CountIntervals(mid + 1, r);
            }
            if (L <= mid) {
                left.add(L, R);
            }
            if (mid < R) {
                right.add(L, R);
            }
            cnt = left.cnt + right.cnt;
        }

        public int count() {
            return cnt;
        }


    }

/**
 * Your CountIntervals object will be instantiated and called as such:
 * CountIntervals obj = new CountIntervals();
 * obj.add(left,right);
 * int param_2 = obj.count();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
        
       