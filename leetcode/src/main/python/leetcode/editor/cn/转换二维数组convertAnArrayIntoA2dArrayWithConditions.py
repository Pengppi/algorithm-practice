"""
Title: 2610.转换二维数组
Title Slug: convertAnArrayIntoA2dArrayWithConditions
Author: Neo
Date: 2025-03-19 12:39:40
"""
from collections import Counter
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def findMatrix(self, nums: List[int]) -> List[List[int]]:
        cnt = Counter(nums)
        ans = []
        while cnt:
            tmp = list(cnt)
            for x in tmp:
                cnt[x] -= 1
                if cnt[x] == 0:
                    del cnt[x]
            ans.append(tmp)

        return ans
# leetcode submit region end(Prohibit modification and deletion)
