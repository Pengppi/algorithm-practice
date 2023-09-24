/**
 * @Title: 146.LRU 缓存
 * @TitleSlug: lruCache
 * @Author: Neo
 * @Date: 2023-09-24 14:02:56
 */
package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class LRU缓存 {
    public static void main(String[] args) {
        //测试代码
//        Solution solution = new LRU缓存().new LRUCache();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class LRUCache {
        private class Node {
            int key, value;
            Node prev, next;

            public Node(int k, int v) {
                key = k;
                value = v;
            }
        }

        private final int capacity;
        private final Node guard = new Node(0, 0);
        private final Map<Integer, Node> mp = new HashMap<>();

        public LRUCache(int capacity) {
            this.capacity = capacity;
            guard.prev = guard;
            guard.next = guard;
        }

        public int get(int key) {
            Node node = getNode(key);
            return node == null ? -1 : node.value;
        }

        public void put(int key, int value) {
            Node node = getNode(key);
            if (node != null) {
                node.value = value;
            } else {
                node = new Node(key, value);
                mp.put(key, node);
                pushForward(node);
                if (mp.size() > capacity) {
                    Node rm = guard.prev;
                    mp.remove(rm.key);
                    removeNode(rm);
                }
            }
        }

        private Node getNode(int key) {
            if (!mp.containsKey(key)) {
                return null;
            }
            Node node = mp.get(key);
            removeNode(node);
            pushForward(node);
            return node;
        }

        private void removeNode(Node x) {
            x.prev.next = x.next;
            x.next.prev = x.prev;
        }

        private void pushForward(Node node) {
            node.next = guard.next;
            node.prev = guard;
            node.next.prev = node;
            node.prev.next = node;
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
        
       