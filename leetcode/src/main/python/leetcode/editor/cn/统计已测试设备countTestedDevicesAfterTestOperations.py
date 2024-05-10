"""
Title: 2960.统计已测试设备
Title Slug: countTestedDevicesAfterTestOperations
Author: Neo
Date: 2024-05-10 11:56:00
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def countTestedDevices(self, batteryPercentages: List[int]) -> int:
        ans, diff = 0, 0
        for bp in batteryPercentages:
            if bp - diff > 0:
                ans += 1
                diff += 1
        return ans

# leetcode submit region end(Prohibit modification and deletion)
