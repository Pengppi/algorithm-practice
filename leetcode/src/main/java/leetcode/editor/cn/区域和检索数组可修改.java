/**
 * @Title: 307.区域和检索 - 数组可修改
 * @TitleSlug: rangeSumQueryMutable
 * @Author: Neo
 * @Date: 2023-11-13 12:46:31
 */
package leetcode.editor.cn;

public class 区域和检索数组可修改 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 区域和检索数组可修改().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class NumArray {

        private int[] segmentTree;
        private int n;


        public NumArray(int[] nums) {
            this.n = nums.length;
            segmentTree = new int[4 * n];
            buildTree(0, 0, n - 1, nums);
        }

        private void buildTree(int o, int l, int r, int[] nums) {
            if (l == r) {
                segmentTree[o] = nums[l];
                return;
            }
            int m = (l + r) / 2;
            buildTree(o * 2 + 1, l, m, nums);
            buildTree(o * 2 + 2, m + 1, r, nums);
            segmentTree[o] = segmentTree[o * 2 + 1] + segmentTree[o * 2 + 2];
        }

        private void update(int index, int val, int o, int l, int r) {
            if (l == r) {
                segmentTree[o] = val;
                return;
            }
            int m = (l + r) / 2;
            if (index <= m) {
                update(index, val, 2 * o + 1, l, m);
            } else {
                update(index, val, 2 * o + 2, m + 1, r);
            }
            segmentTree[o] = segmentTree[o * 2 + 1] + segmentTree[o * 2 + 2];
        }

        public int query(int o, int s, int e, int l, int r) {
            if (l <= s && e <= r) {
                return segmentTree[o];
            }
            int m = (s + e) / 2, ans = 0;
            if (l <= m) {
                ans += query(o * 2 + 1, s, m, l, r);
            }
            if (r > m) {
                ans += query(o * 2 + 2, m+1, e, l, r);
            }
            return ans;
        }

        public void update(int index, int val) {
            update(index, val, 0, 0, n-1);
        }

        public int sumRange(int left, int right) {
            return query(0, 0, n - 1, left, right);
        }
    }

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
        
       