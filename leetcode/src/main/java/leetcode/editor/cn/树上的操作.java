/**
 * @Title: 1993.树上的操作
 * @TitleSlug: operationsOnTree
 * @Author: Neo
 * @Date: 2023-09-23 16:23:43
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 树上的操作 {
    public static void main(String[] args) {
        //测试代码
//        Solution solution = new 树上的操作().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class LockingTree {

        Map<Integer, Integer> lck;

        List<Integer>[] lists;

        int[] parent;

        public LockingTree(int[] parent) {
            lck = new HashMap<>();
            this.parent = parent;
            int n = parent.length;
            lists = new List[n];
            for (int i = 0; i < n; i++) {
                lists[i] = new ArrayList<>();
            }
            for (int i = 1; i < n; i++) {
                int f = parent[i];
                while (f != -1) {
                    lists[f].add(i);
                    f = parent[f];
                }
            }
        }

        public boolean lock(int num, int user) {
            if (lck.containsKey(num)) {
                return false;
            }
            lck.put(num, user);
            return true;
        }

        public boolean unlock(int num, int user) {
            if (lck.containsKey(num) && lck.get(num) == user) {
                lck.remove(num);
                return true;
            }
            return false;
        }

        public boolean upgrade(int num, int user) {
            if (lck.containsKey(num)) {
                return false;
            }
            boolean flg = false;
            for (Integer kid : lists[num]) {
                if (lck.containsKey(kid)) {
                    flg = true;
                    break;
                }
            }
            if (!flg) {
                return false;
            }
            int f = parent[num];
            while (f != -1) {
                if (lck.containsKey(f)) {
                    flg = false;
                    break;
                }
                f = parent[f];
            }
            if (!flg) {
                return false;
            }
            lck.put(num, user);
            for (Integer kid : lists[num]) {
                if (lck.containsKey(kid)) {
                    lck.remove(kid);
                }
            }
            return true;
        }
    }

/**
 * Your LockingTree object will be instantiated and called as such:
 * LockingTree obj = new LockingTree(parent);
 * boolean param_1 = obj.lock(num,user);
 * boolean param_2 = obj.unlock(num,user);
 * boolean param_3 = obj.upgrade(num,user);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
        
       