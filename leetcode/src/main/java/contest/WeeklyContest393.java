/**
 * @Author: Neo
 * @Date: 2024/04/14 Sunday 10:26
 * @Project: practice
 * @IDE: IntelliJ IDEA
 **/

package contest;

import java.util.Arrays;
import java.util.TreeSet;

public class WeeklyContest393 {
    public static void main(String[] args) {
        WeeklyContest393 solution = new WeeklyContest393();
        int[] coins = {5, 2};
        int k = 7;
        System.out.println(solution.findKthSmallest(coins, k));
    }
    
    public long findKthSmallest(int[] coins, int k) {
        Arrays.sort(coins);
        long mx = (long) coins[0] * k;
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 1; i <= k; i++) {
            for (int coin : coins) {
                long cur = (long) coin * i;
                if (set.size() < k) {
                    set.add(cur);
                } else {
                    long max = set.last();
                    if (set.contains(cur)) {
                        continue;
                    }
                    if (max > cur) {
                        set.pollLast();
                        set.add(cur);
                    } else {
                        break;
                    }
                }
            }
        }
        return set.last();
    }
    
    
    public int maximumPrimeDifference(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            while (!isPrime(nums[l])) {
                l++;
            }
            while (!isPrime(nums[r])) {
                r--;
            }
            return r - l;
        }
        return 0;
    }
    
    private boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    
    public String findLatestTime(String s) {
        char[] a = s.toCharArray();
        for (int i = 0; i < a.length; i++) {
            if (a[i] != '?') {
                continue;
            }
            if (i == 0) {
                if (a[1] == '?' || a[1] < '2') {
                    a[i] = '1';
                } else {
                    a[i] = '0';
                }
            } else if (i == 1) {
                if (a[0] == '0') {
                    a[i] = '9';
                } else {
                    a[i] = '1';
                }
            } else if (i == 3) {
                a[i] = '5';
            } else {
                a[i] = '9';
            }
            
        }
        return new String(a);
    }
}
