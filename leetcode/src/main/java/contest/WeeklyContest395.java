/**
 * @Author: Neo
 * @Date: 2024/04/28 Sunday 10:29
 * @Project: practice
 * @IDE: IntelliJ IDEA
 **/

package contest;

import java.util.Arrays;
import java.util.HashMap;

public class WeeklyContest395 {
    
    public long minEnd(int n, int x) {
        long ans = 0;
        int oneNum = Integer.bitCount(x);
        
        return ans;
    }
    
    
    public int minimumAddedInteger(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
        }
        int ans = Integer.MAX_VALUE;
        for (int k = 0; k < 3; k++) {
            int res = nums2[0] - nums1[k];
            int cnt = 1;
            HashMap<Integer, Integer> tmp = new HashMap<>(map);
            tmp.put(nums1[k], tmp.get(nums1[k]) - 1);
            for (int i = 1; i < nums2.length; i++) {
                int key = nums2[i] - res;
                if (tmp.getOrDefault(key, 0) <= 0) {
                    break;
                }
                tmp.merge(key, -1, Integer::sum);
                cnt++;
            }
            if (cnt == nums2.length) {
                ans = Math.min(ans, res);
            }
        }
        return ans;
    }
    
    
    public int addedInteger(int[] nums1, int[] nums2) {
        int mx1 = Arrays.stream(nums1).max().getAsInt();
        int mx2 = Arrays.stream(nums2).max().getAsInt();
        return mx2 - mx1;
    }
    
}
