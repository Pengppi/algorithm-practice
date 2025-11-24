"""
Title: 1437.Check If All 1's Are at Least Length K Places Away
Title Slug: checkIfAll1sAreAtLeastLengthKPlacesAway
Author: Neo
Date: 2025-11-17 12:48:16
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def kLengthApart(self, nums: List[int], k: int) -> bool:
        last = -k - 1
        for i, x in enumerate(nums):
            if x:
                if i - last - 1 < k:
                    return False
                last = i
        return True

# leetcode submit region end(Prohibit modification and deletion)
