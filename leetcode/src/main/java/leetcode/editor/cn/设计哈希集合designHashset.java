/**
 * @Title: 705.设计哈希集合
 * @TitleSlug: designHashset
 * @Author: Neo
 * @Date: 2024-04-14 00:16:45
 */
package leetcode.editor.cn;

public class 设计哈希集合designHashset {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 设计哈希集合designHashset().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class MyHashSet {
        
        private final int capacity;
        private final Node[] nodes;
        
        public MyHashSet() {
            int n = -1 >>> Integer.numberOfLeadingZeros((int) (1e6 - 1));
            capacity = n;
            nodes = new Node[capacity];
        }
        
        public void add(int key) {
            if (contains(key)) {
                return;
            }
            Node node = new Node(key);
            int idx = getIndex(key);
            node.next = nodes[idx];
            nodes[idx] = node;
        }
        
        public boolean contains(int key) {
            int idx = getIndex(key);
            boolean res = false;
            Node cur = nodes[idx];
            while (cur != null) {
                if (cur.key == key) {
                    res = true;
                    break;
                }
                cur = cur.next;
            }
            return res;
        }
        
        private int getIndex(int key) {
            return (key ^ (key >>> 16)) & (capacity - 1);
        }
        
        public void remove(int key) {
            int idx = getIndex(key);
            Node cur = nodes[idx];
            if (cur == null) {
                return;
            }
            if (cur.key == key) {
                nodes[idx] = cur.next;
                return;
            }
            while (cur.next != null) {
                if (cur.next.key == key) {
                    cur.next = cur.next.next;
                    break;
                }
                cur = cur.next;
            }
        }
        
        private class Node {
            public int key;
            public Node next;
            
            public Node(int key) {
                this.key = key;
                next = null;
            }
        }
        
        
    }

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
// leetcode submit region end(Prohibit modification and deletion)

}
       