/**
 * @Title: 2671.频率跟踪器
 * @TitleSlug: frequencyTracker
 * @Author: Neo
 * @Date: 2024-03-21 09:25:44
 */
package leetcode.editor.cn;

public class 频率跟踪器frequencyTracker {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 频率跟踪器frequencyTracker().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class FrequencyTracker {
        private final int N = 100005;
        private int[] nums;
        private int[] freq;
        
        public FrequencyTracker() {
            nums = new int[N];
            freq = new int[N];
        }
        
        public void add(int number) {
            if (nums[number] != 0) {
                freq[nums[number]]--;
            }
            nums[number]++;
            freq[nums[number]]++;
            
        }
        
        public void deleteOne(int number) {
            if (nums[number] != 0) {
                freq[nums[number]]--;
                nums[number]--;
                freq[nums[number]]++;
            }
        }
        
        public boolean hasFrequency(int frequency) {
            return freq[frequency] > 0;
        }
    }
/**
 * Your FrequencyTracker object will be instantiated and called as such:
 * FrequencyTracker obj = new FrequencyTracker();
 * obj.add(number);
 * obj.deleteOne(number);
 * boolean param_3 = obj.hasFrequency(frequency);
 */
// leetcode submit region end(Prohibit modification and deletion)

}
       