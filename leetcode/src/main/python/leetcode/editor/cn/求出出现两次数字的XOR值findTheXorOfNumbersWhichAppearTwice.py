"""
Title: 3158.求出出现两次数字的 XOR 值
Title Slug: findTheXorOfNumbersWhichAppearTwice
Author: Neo
Date: 2024-10-12 12:39:04
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def duplicateNumbersXOR(self, nums: List[int]) -> int:
        st=set()
        ans = 0
        for x in nums:
            if x in st:
                ans^=x
            else:
                st.add(x)
        return ans

# leetcode submit region end(Prohibit modification and deletion)
