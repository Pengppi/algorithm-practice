/**
 * @Title: 1172.餐盘栈
 * @TitleSlug: dinnerPlateStacks
 * @Author: Neo
 * @Date: 2023-04-28 10:36:38
 */
package leetcode.editor.cn;

import java.util.Deque;
import java.util.TreeSet;

public class 餐盘栈 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 餐盘栈().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class DinnerPlates {
        private List<Deque<Integer>> stacks = new ArrayList<>();
        private int capacity;
        private TreeSet<Integer> notFull = new TreeSet<>();

        public DinnerPlates(int capacity) {
            this.capacity = capacity;
        }

        public void push(int val) {
            if (notFull.isEmpty()) {
                stacks.add(new ArrayDeque<>());
                stacks.get(stacks.size() - 1).push(val);
                if (capacity > 1) {
                    notFull.add(stacks.size() - 1);
                }
            } else {
                int index = notFull.first();
                stacks.get(index).push(val);
                if (stacks.get(index).size() == capacity) {
                    notFull.pollFirst();
                }
            }

        }

        public int pop() {
            return popAtStack(stacks.size() - 1);
        }

        public int popAtStack(int index) {
            if (index < 0 || index >= stacks.size() || stacks.get(index).isEmpty()) {
                return -1;
            }

            int val = stacks.get(index).pop();
            if (index == stacks.size() - 1 && stacks.get(index).isEmpty()) {
                while (!stacks.isEmpty() && stacks.get(stacks.size() - 1).isEmpty()) {
                    notFull.remove(stacks.size() - 1);
                    stacks.remove(stacks.size() - 1);
                }
            } else {
                notFull.add(index);
            }
            return val;
        }
    }

    /**
     * Your DinnerPlates object will be instantiated and called as such:
     * DinnerPlates obj = new DinnerPlates(capacity);
     * obj.push(val);
     * int param_2 = obj.pop();
     * int param_3 = obj.popAtStack(index);
     */
    //leetcode submit region end(Prohibit modification and deletion)

}

}