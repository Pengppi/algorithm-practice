/**
 * @Title: 1600.王位继承顺序
 * @TitleSlug: throneInheritance
 * @Author: Neo
 * @Date: 2024-04-07 00:53:06
 */
package leetcode.editor.cn;

import java.util.*;

public class 王位继承顺序throneInheritance {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 王位继承顺序throneInheritance().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class ThroneInheritance {
        private Set<String> death;
        private List<String> curOrder;
        private Map<String, List<String>> tree;
        private boolean flg = true;
        private String king;
        
        public ThroneInheritance(String kingName) {
            death = new HashSet<>();
            curOrder = new ArrayList<>();
            tree = new HashMap<>();
            curOrder.add(kingName);
            tree.put(kingName, new ArrayList<>());
            king = kingName;
        }
        
        public void birth(String parentName, String childName) {
            flg = true;
            tree.compute(parentName, (k, v) -> {
                if (v == null) {
                    v = new ArrayList<>();
                }
                v.add(childName);
                return v;
            });
        }
        
        
        public void death(String name) {
            death.add(name);
            flg = true;
        }
        
        public List<String> getInheritanceOrder() {
            if (flg) {
                curOrder.clear();
                dfs(king);
            }
            return curOrder;
        }
        
        private void dfs(String name) {
            if (!death.contains(name)) {
                curOrder.add(name);
            }
            if (!tree.containsKey(name)) {
                return;
            }
            for (String next : tree.get(name)) {
                dfs(next);
            }
        }
    }

/**
 * Your ThroneInheritance object will be instantiated and called as such:
 * ThroneInheritance obj = new ThroneInheritance(kingName);
 * obj.birth(parentName,childName);
 * obj.death(name);
 * List<String> param_3 = obj.getInheritanceOrder();
 */
// leetcode submit region end(Prohibit modification and deletion)

}
       