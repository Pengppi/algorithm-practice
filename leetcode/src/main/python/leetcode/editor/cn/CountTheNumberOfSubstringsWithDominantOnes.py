"""
Title: 3234.Count the Number of Substrings With Dominant Ones
Title Slug: countTheNumberOfSubstringsWithDominantOnes
Author: Neo
Date: 2025-11-15 14:52:02
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def numberOfSubstrings(self, s: str) -> int:

        n = len(s)
        pz = [i for i in range(n) if s[i] == '0']
        tot1 = n - len(pz)
        pz.append(n)
        ans = zero_start = 0
        for i, c in enumerate(s):
            for zero_idx in range(zero_start, len(pz) - 1):
                cnt0 = zero_idx - zero_start + 1
                cnt0_product = cnt0 * cnt0
                if cnt0_product > tot1:
                    break
                cnt1 = pz[zero_idx] - i + 1 - cnt0
                if cnt1 >= cnt0_product:
                    ans += pz[zero_idx + 1] - pz[zero_idx]
                else:
                    ans += max(0, pz[zero_idx + 1] - pz[zero_idx] - (cnt0_product - cnt1))

            if c == '0':
                zero_start += 1
            else:
                ans += pz[zero_start] - i
                tot1 -= 1

        return ans

# leetcode submit region end(Prohibit modification and deletion)
