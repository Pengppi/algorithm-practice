"""
Title: 2105.给植物浇水 II
Title Slug: wateringPlantsIi
Author: Neo
Date: 2024-05-09 22:08:50
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minimumRefill(self, plants: List[int], capacityA: int, capacityB: int) -> int:
        l, r = 0, len(plants) - 1
        cur1, cur2 = capacityA, capacityB
        ans = 0
        while l <= r:
            if l == r:
                if max(cur2, cur1) < plants[l]:
                    ans += 1
                break
            if cur1 < plants[l]:
                cur1 = capacityA - plants[l]
                ans += 1
            else:
                cur1 -= plants[l]
            if cur2 < plants[r]:
                cur2 = capacityB - plants[r]
                ans += 1
            else:
                cur2 -= plants[r]
            l += 1
            r -= 1

        return ans


# leetcode submit region end(Prohibit modification and deletion)

inst = Solution()
print(inst.minimumRefill(
    [726, 739, 934, 116, 643, 648, 473, 984, 482, 85, 850, 806, 146, 764, 156, 66, 186, 339, 985, 237, 662, 552, 800,
     78, 617, 933, 481, 652, 796, 594, 151, 82, 183, 241, 525, 221, 951, 732, 799, 483, 368, 354, 776, 175, 974, 187,
     913, 842], 1439, 1207))
