"""
Title: 2748.美丽下标对的数目
Title Slug: numberOfBeautifulPairs
Author: Neo
Date: 2024-06-20 12:42:45
"""
from collections import defaultdict
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def countBeautifulPairs(self, nums: List[int]) -> int:
        def gcd(a: int, b: int) -> int:
            return a if b == 0 else gcd(b, a % b)

        map = defaultdict(int)
        ans = 0
        for num in nums:
            s = str(num)
            l, r = int(s[0]), int(s[-1])
            for (x, y) in map.items():
                if gcd(x, r) == 1:
                    ans += y
            map[l] += 1
        return ans

# leetcode submit region end(Prohibit modification and deletion)
