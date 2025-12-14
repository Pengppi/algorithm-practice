"""
Title: 3606.Coupon Code Validator
Title Slug: couponCodeValidator
Author: Neo
Date: 2025-12-13 21:54:05
"""

# leetcode submit region begin(Prohibit modification and deletion)
from typing import List


class Solution:

    def validateCoupons(self, code: List[str], businessLine: List[str],
                        isActive: List[bool]) -> List[str]:
        business_dict = {
            "electronics": 0,
            "grocery": 1,
            "pharmacy": 2,
            "restaurant": 3
        }

        valids = [[] for _ in range(len(business_dict))]

        for cod, business, isA in zip(code, businessLine, isActive):
            i = business_dict.get(business, -1)
            if i > -1 and isA and cod and \
                all(c == '_' or c.isalnum() for c in cod):
                valids[i].append(cod)

        ans = []
        for val in valids:
            val.sort()
            ans.extend(val)
        return ans


# leetcode submit region end(Prohibit modification and deletion)
