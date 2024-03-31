/**
 * @Author: Neo
 * @Date: 2024/03/30 星期六 22:37
 * @Project: practice
 * @IDE: IntelliJ IDEA
 **/

package contest;

import java.util.ArrayList;
import java.util.Arrays;

public class BiweeklyContest127 {
    int[] nums;
    int n, mod = (int) (1e9 + 7), inf = Integer.MAX_VALUE, ans = 0;
    
    public int sumOfPowers(int[] nums, int k) {
        Arrays.sort(nums);
        this.nums = nums;
        this.n = nums.length;
        dfs(0, k, new ArrayList<>(), inf);
        return ans;
    }
    
    private void dfs(int x, int k, ArrayList<Integer> list, int res) {
        if (list.size() == k) {
            ans = (ans + res) % mod;
        }
        for (int i = x; i < n; i++) {
            list.add(nums[i]);
            int curRes = res;
            if (list.size() > 1) {
                curRes = Math.min(res, list.get(list.size() - 1) - list.get(list.size() - 2));
            }
            dfs(i + 1, k, list, curRes);
            list.remove(list.size() - 1);
        }
    }
    
    public int minimumSubarrayLength(int[] nums, int k) {
        int n = nums.length, ans = Integer.MAX_VALUE, l = 0;
        int[] bits = new int[32];
        for (int r = 0; r < n; r++) {
            int sum = or(bits, nums[r]);
            while (sum >= k && l <= r) {
                ans = Math.min(ans, r - l + 1);
                sum = cancelOr(bits, nums[l++]);
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    
    private int or(int[] bits, int num) {
        int sum = 0;
        for (int i = 0; i < 32; i++) {
            if ((num & (1 << i)) != 0) {
                bits[i]++;
            }
            if (bits[i] > 0) {
                sum |= 1 << i;
            }
        }
        return sum;
    }
    
    private int cancelOr(int[] bits, int num) {
        int sum = 0;
        for (int i = 0; i < 32; i++) {
            if ((num & (1 << i)) != 0) {
                bits[i]--;
            }
            if (bits[i] > 0) {
                sum |= 1 << i;
            }
        }
        return sum;
    }
    
    public int minimumLevels(int[] possible) {
        int tot = 0, n = possible.length;
        for (int i = 0; i < n; i++) {
            tot += possible[i] == 0 ? -1 : 1;
        }
        int cur = 0, target = tot >> 1;
        for (int i = 0; i < n - 1; i++) {
            cur += possible[i] == 0 ? -1 : 1;
            if (cur > target) {
                return i + 1;
            }
        }
        return -1;
    }
    
    public int minimumSubarrayLength1(int[] nums, int k) {
        int n = nums.length;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j + i <= n; j++) {
                int sum = 0;
                for (int l = j; l < j + i; l++) {
                    sum |= nums[l];
                }
                if (sum >= k) {
                    return i;
                }
            }
        }
        return -1;
    }
    
    
}
