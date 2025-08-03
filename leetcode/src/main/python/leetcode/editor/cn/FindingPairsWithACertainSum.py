"""
Title: 1865.Finding Pairs With a Certain Sum
Title Slug: findingPairsWithACertainSum
Author: Neo
Date: 2025-07-06 15:45:40
"""
from collections import defaultdict
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class FindSumPairs:

    def __init__(self, nums1: List[int], nums2: List[int]):
        def get_counter(nums: List[int]):
            cnt = defaultdict(int)
            for num in nums:
                cnt[num] += 1
            return cnt
        self.cnt1 = get_counter(nums1)
        self.cnt2 = get_counter(nums2)
        self.nums2 = nums2

    def add(self, index: int, val: int) -> None:
        old_val = self.nums2[index]
        self.cnt2[old_val] -= 1
        self.nums2[index] += val
        self.cnt2[self.nums2[index]] += 1

    def count(self, tot: int) -> int:
        ans = 0
        for k, v in self.cnt1.items():
            if k > tot or tot - k not in self.cnt2:
                continue
            ans += v * self.cnt2[tot - k]
        return ans

# Your FindSumPairs object will be instantiated and called as such:
# obj = FindSumPairs(nums1, nums2)
# obj.add(index,val)
# param_2 = obj.count(tot)
# leetcode submit region end(Prohibit modification and deletion)

s =  FindSumPairs([1,1,2,2,2,3], [1,4,5,2,5,4])
s.count(7)
