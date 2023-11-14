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

        int tree[];

        int lowbit(int x) {
            return x & -x;
        }

        void add(int x, int v) {
            for (int i = x; i <= n; i += lowbit(i)) {
                tree[i] += v;
            }
        }

        int query(int x) {
            int ans = 0;
            for (int i = x; i > 0; i -= lowbit(i)) {
                ans += tree[i];
            }
            return ans;
        }


        int n;
        int nums[];

        public NumArray(int[] nums) {
            n = nums.length;
            this.nums = nums;
            tree = new int[n + 1];
            for (int i = 0; i < n; i++) {
                add(i + 1, nums[i]);

            }
        }

        public void update(int index, int val) {
            add(index + 1, val - nums[index]);
            nums[index] = val;
        }

        public int sumRange(int left, int right) {
            return query(right + 1) - query(left);
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
        
       