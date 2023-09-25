/**
 * @Title: 460.LFU 缓存
 * @TitleSlug: lfuCache
 * @Author: Neo
 * @Date: 2023-09-25 00:11:06
 */
package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class LFU缓存 {
    public static void main(String[] args) {
        //测试代码
//        Solution solution = new LFU缓存().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class LFUCache {

        private class Node {
            int key, val, cnt;
            Node prev, next;

            Node(int k, int v) {
                key = k;
                val = v;
                cnt = 1;
            }
        }

        private final int capacity;

        private int minCnt = 1;

        private Map<Integer, Node> keyToNode = new HashMap<>();

        private Map<Integer, Node> cntToNode = new HashMap<>();

        public LFUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            Node x = getNode(key);
            return x == null ? -1 : x.val;
        }

        public void put(int key, int value) {
            Node x = getNode(key);
            if (x != null) {
                x.val = value;
                return;
            }
            if (keyToNode.size() == capacity) {
                Node dummy = cntToNode.get(minCnt);
                Node del = dummy.prev;
                keyToNode.remove(del.key);
                removeNode(del);
                if (dummy.prev == dummy) {
                    cntToNode.remove(dummy);
                }
            }
            x = new Node(key, value);
            minCnt = 1;
            addNode(x.cnt, x);
            keyToNode.put(key, x);
        }

        private Node getNode(int key) {
            if (!keyToNode.containsKey(key)) {
                return null;
            }
            Node x = keyToNode.get(key);
            removeNode(x);
            Node dummy = cntToNode.get(x.cnt);
            if (dummy.prev == dummy) {
                cntToNode.remove(x.cnt);
                if (minCnt == x.cnt) {
                    minCnt++;
                }
            }
            addNode(++x.cnt, x);
            return x;
        }

        private void removeNode(Node x) {
            x.prev.next = x.next;
            x.next.prev = x.prev;
        }

        private void addNode(int cnt, Node x) {
            Node dummy = cntToNode.computeIfAbsent(cnt, d -> newList());
            x.prev = dummy;
            x.next = dummy.next;
            x.prev.next = x;
            x.next.prev = x;
        }

        private Node newList() {
            Node dummy = new Node(-1, -1);
            dummy.next = dummy;
            dummy.prev = dummy;
            return dummy;
        }
    }

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
        
       