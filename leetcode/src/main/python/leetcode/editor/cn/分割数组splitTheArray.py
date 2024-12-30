"""
Title: 3046.分割数组
Title Slug: splitTheArray
Author: Neo
Date: 2024-12-28 21:23:04
"""
from collections import Counter
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def isPossibleToSplit(self, nums: List[int]) -> bool:
        cnt = Counter(nums)

        return not any(cnt[x] > 2 for x in cnt)



        
# leetcode submit region end(Prohibit modification and deletion)

