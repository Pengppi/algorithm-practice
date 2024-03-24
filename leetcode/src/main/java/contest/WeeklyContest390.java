/**
 * @Author: Neo
 * @Date: 2024/03/24 星期日 10:56 上午
 * @Project: practice
 * @IDE: IntelliJ IDEA
 **/

package contest;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class WeeklyContest390 {
    
    
    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        Tire root = new Tire();
        int mnLen = 0;
        for (int i = 0; i < wordsContainer.length; i++) {
            root.insert(wordsContainer, i);
            if (wordsContainer[i].length() < wordsContainer[mnLen].length()) {
                mnLen = i;
            }
        }
        int[] ans = new int[wordsQuery.length];
        for (int i = 0; i < wordsQuery.length; i++) {
            int res = root.search(wordsQuery[i]);
            ans[i] = res == -1 ? mnLen : res;
        }
        return ans;
    }
    
    public long[] mostFrequentIDs(int[] nums, int[] freq) {
        int n = nums.length;
        long[] ans = new long[n];
        Map<Integer, Long> cnt = new HashMap<>();
        TreeMap<Long, Integer> freqMap = new TreeMap<>();
        freqMap.put(0L, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            Long old = cnt.getOrDefault(nums[i], 0L);
            Long newCnt = old + freq[i];
            if (newCnt < 0) {
                newCnt = 0L;
            }
            cnt.put(nums[i], newCnt);
            freqMap.put(old, freqMap.get(old) - 1);
            if (freqMap.get(old) == 0) {
                freqMap.remove(old);
            }
            freqMap.put(newCnt, freqMap.getOrDefault(newCnt, 0) + 1);
            ans[i] = freqMap.lastKey();
        }
        return ans;
    }
    
    public int minOperations(int k) {
        if (k == 1) {
            return 0;
        }
        int sum = 1;
        int ans = k;
        while (sum < k) {
            sum++;
            ans = Math.min(ans, (k + sum - 1) / sum - 1 + sum - 1);
        }
        return ans;
    }
    
    public int maximumLengthSubstring(String s) {
        int n = s.length();
        int[] cnt = new int[26];
        int res = 0;
        int l = 0, r = 0;
        while (r < n) {
            int idx = s.charAt(r) - 'a';
            cnt[idx]++;
            while (cnt[idx] > 2) {
                cnt[s.charAt(l) - 'a']--;
                l++;
            }
            res = Math.max(res, r - l + 1);
            r++;
        }
        return res;
    }
    
    class Tire {
        Tire[] children;
        int id;
        boolean isEnd;
        
        public Tire() {
            children = new Tire[26];
            isEnd = false;
            id = -1;
        }
        
        
        public void insert(String[] words, int id) {
            Tire node = this;
            for (int i = words[id].length() - 1; i >= 0; i--) {
                int idx = words[id].charAt(i) - 'a';
                if (node.children[idx] == null) {
                    node.children[idx] = new Tire();
                }
                node = node.children[idx];
                if (node.id == -1) {
                    node.id = id;
                } else if (words[node.id].length() > words[id].length()) {
                    node.id = id;
                }
            }
            node.isEnd = true;
        }
        
        public int search(String word) {
            Tire node = this;
            for (int i = word.length() - 1; i >= 0; i--) {
                int idx = word.charAt(i) - 'a';
                if (node.children[idx] == null) {
                    return node.id;
                }
                node = node.children[idx];
            }
            return node.id;
        }
    }
    
    
}
