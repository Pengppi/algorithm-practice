/**
 * @Title: 715.Range 模块
 * @TitleSlug: rangeModule
 * @Author: Neo
 * @Date: 2023-11-12 12:10:44
 */
package leetcode.editor.cn;

public class Range模块 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new Range模块().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class RangeModule {

        class Node {
            Node left, right;
            boolean cover;
            int tag;
        }

        private Node root;
        private int N = (int) 1e+9;

        private void update(Node o, int s, int e, int l, int r, boolean flg) {
            if (l <= s && e <= r) {
                o.cover = flg;
                o.tag = flg ? 1 : 0;
                return;
            }
            int m = (s + e) / 2;
            pushDown(o);
            if (l <= m) {
                update(o.left, s, m, l, r, flg);
            }
            if (r > m) {
                update(o.right, m + 1, e, l, r, flg);
            }
            pushUp(o);
        }

        private boolean query(Node o, int s, int e, int l, int r) {
            if (l <= s && e <= r) {
                return o.cover;
            }
            int m = (s + e) / 2;
            pushDown(o);
            boolean ans = true;
            if (l <= m) {
                ans &= query(o.left, s, m, l, r);
            }
            if (r > m) {
                ans &= query(o.right, m + 1, e, l, r);
            }
            return ans;
        }

        private void pushDown(Node o) {
            if (o.left == null) {
                o.left = new Node();
            }
            if (o.right == null) {
                o.right = new Node();
            }
            if (o.tag == 0) {
                return;
            }
            o.left.cover = o.tag == 1;
            o.right.cover = o.tag == 1;
            o.left.tag = o.tag;
            o.right.tag = o.tag;
            o.tag = 0;
        }

        private void pushUp(Node o) {
            o.cover = o.left.cover & o.right.cover;
        }

        public RangeModule() {
            root = new Node();
        }

        public void addRange(int left, int right) {
            update(root, 0, N, left, right - 1, true);
        }

        public boolean queryRange(int left, int right) {
            return query(root, 0, N, left, right - 1);
        }

        public void removeRange(int left, int right) {
            update(root, 0, N, left, right - 1, false);
        }
    }

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
        
       