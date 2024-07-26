"""
Title: 2766.重新放置石块
Title Slug: relocateMarbles
Author: Neo
Date: 2024-07-24 10:03:04
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def relocateMarbles(self, nums: List[int], moveFrom: List[int], moveTo: List[int]) -> List[int]:
        st = set(nums)
        for fr, to in zip(moveFrom, moveTo):
            if fr in st:
                st.remove(fr)
                st.add(to)

        return sorted(st)
# leetcode submit region end(Prohibit modification and deletion)
