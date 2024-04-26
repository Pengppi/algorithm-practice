/**
 * @Title: 1146.快照数组
 * @TitleSlug: snapshotArray
 * @Author: Neo
 * @Date: 2024-04-26 12:32:56
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 快照数组snapshotArray {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 快照数组snapshotArray().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class SnapshotArray {
        
        private int snapCount;
        private List[] indexSnap;
        
        public SnapshotArray(int length) {
            snapCount = 0;
            indexSnap = new List[length];
            Arrays.setAll(indexSnap, e -> new ArrayList<int[]>());
        }
        
        public void set(int index, int val) {
            List<int[]> list = indexSnap[index];
            if (!list.isEmpty()) {
                int[] tail = list.get(list.size() - 1);
                if (tail[0] == snapCount) {
                    tail[1] = val;
                    return;
                }
            }
            list.add(new int[]{snapCount, val});
        }
        
        public int snap() {
            return snapCount++;
        }
        
        public int get(int index, int snap_id) {
            List<int[]> list = indexSnap[index];
            int left = 0, right = list.size() - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                int[] arr = list.get(mid);
                if (arr[0] == snap_id) {
                    return arr[1];
                } else if (arr[0] < snap_id) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return left == 0 ? 0 : list.get(left - 1)[1];
        }
    }

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */
// leetcode submit region end(Prohibit modification and deletion)

}
       