"""
Title: 3507.Minimum Pair Removal to Sort Array I
Title Slug: minimumPairRemovalToSortArrayI
Author: Neo
Date: 2026-01-22 11:26:53
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def check(self, nums):
        n = len(nums)
        i = 0
        while i < n - 1:
            if nums[i] > nums[i + 1]:
                return False
            i += 1
        return True

    def minimumPairRemoval(self, nums: List[int]) -> int:
        n = len(nums)
        ans = 0
        # 需要替换
        while not self.check(nums):
            n = len(nums)
            # 退出
            if n < 2:
                break
            target = inf
            target_idx = 0
            # 找最左边的，相邻元素和最小的一对
            for i in range(n - 1):
                # 找最左边的，所以不能等于
                if nums[i] + nums[i + 1] < target:
                    target = nums[i] + nums[i + 1]
                    target_idx = i
            nums = nums[:target_idx] + [target] + nums[target_idx + 2:]
            ans += 1
        return ans
# leetcode submit region end(Prohibit modification and deletion)
