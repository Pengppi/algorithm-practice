"""
Title: 860.柠檬水找零
Title Slug: lemonadeChange
Author: Neo
Date: 2024-11-17 20:35:15
"""
from collections import defaultdict
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def lemonadeChange(self, bills: List[int]) -> bool:
        five = 0
        ten = 0

        for b in bills:
            if b == 5:
                five += 1
            elif b == 10:
                if five == 0:
                    return False
                ten += 1
                five -= 1
            else:
                if ten > 0 and five > 0:
                    ten -= 1
                    five -= 1
                elif five >= 3:
                    five -= 3
                else:
                    return False
        return True
# leetcode submit region end(Prohibit modification and deletion)
