/**
 * @Author: Neo
 * @Date: 2024/03/31 星期日 10:32 上午
 * @Project: practice
 * @IDE: IntelliJ IDEA
 **/

package contest;

import java.util.Arrays;

public class WeeklyContest391 {
    public int minimumDistance(int[][] points) {
        Arrays.sort(points, (a, b) -> a[0] - b[0] == 0 ? a[1] - b[1] : a[0] - b[0]);
        int n = points.length;
        int[][] f = new int[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(f[i], Integer.MAX_VALUE);
        }
        int ans = Integer.MAX_VALUE;
        for (int j = 1; j <= n; j++) {
            f[j][j] = f[j - 1][0];
            for (int i = j + 1; i <= n; i++) {
                if (f[i][0] == f[i - 1][0]) {
                
                }
            }
        }
        
        return ans;
    }
    
    private int dist(int[] p1, int[] p2) {
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }
    
    
    public long countAlternatingSubarrays(int[] nums) {
        long ans = 0;
        int n = nums.length, r = n;
        for (int i = n - 1; i >= 0; i--) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                ans += (long) (r - i) * (r - i + 1) / 2;
                r = i;
            } else if (i == 0) {
                ans += (long) (r - i) * (r - i + 1) / 2;
            }
        }
        return ans;
    }
    
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int ans = numBottles;
        while (numBottles >= numExchange) {
            numBottles -= numExchange;
            ans++;
            numBottles++;
            numExchange++;
        }
        return ans;
    }
    
    public int sumOfTheDigitsOfHarshadNumber(int x) {
        int sum = 0, temp = x;
        while (temp > 0) {
            sum += temp % 10;
            temp /= 10;
        }
        if (x % sum == 0) {
            return sum;
        }
        return -1;
    }
}
