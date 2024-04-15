/**
 * @Title: 706.设计哈希映射
 * @TitleSlug: designHashmap
 * @Author: Neo
 * @Date: 2024-04-15 20:10:36
 */
package leetcode.editor.cn;

public class 设计哈希映射designHashmap {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 设计哈希映射designHashmap().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class MyHashMap {
        
        private int capacity;
        private Node[] nodes;
        
        public MyHashMap() {
            capacity = -1 >>> Integer.numberOfLeadingZeros((int) (1e6 - 1));
            nodes = new Node[capacity];
        }
        
        public void put(int key, int value) {
            int idx = getIndex(key);
            Node cur = nodes[idx];
            while (cur != null) {
                if (cur.key == key) {
                    cur.value = value;
                    return;
                }
                cur = cur.next;
            }
            Node node = new Node(key, value);
            node.next = nodes[idx];
            nodes[idx] = node;
        }
        
        private int getIndex(int key) {
            return (key ^ (key >>> 16)) & (capacity - 1);
        }
        
        public int get(int key) {
            int idx = getIndex(key);
            Node cur = nodes[idx];
            while (cur != null) {
                if (cur.key == key) {
                    return cur.value;
                }
                cur = cur.next;
            }
            return -1;
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
                    return;
                }
                cur = cur.next;
            }
        }
        
        private class Node {
            int key;
            int value;
            Node next;
            
            public Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }
    }

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
// leetcode submit region end(Prohibit modification and deletion)

}
       