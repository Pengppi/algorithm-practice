/**
 * @Title: 146.LRU 缓存
 * @TitleSlug: lruCache
 * @Author: Neo
 * @Date: 2024-04-10 13:19:58
 */
package leetcode.editor.cn;

import java.util.LinkedHashMap;

public class LRU缓存lruCache {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new LRU缓存lruCache().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class LRUCache {
        
        private final int capacity;
        
        private final LinkedHashMap<Integer, Integer> cache;
        
        public LRUCache(int capacity) {
            this.capacity = capacity;
            cache = new LinkedHashMap<>(capacity, 0.75f, true);
        }
        
        public int get(int key) {
            return cache.getOrDefault(key, -1);
        }
        
        public void put(int key, int value) {
            cache.put(key, value);
            if (cache.size() > capacity) {
                cache.remove(cache.entrySet().iterator().next().getKey());
            }
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// leetcode submit region end(Prohibit modification and deletion)

}
       