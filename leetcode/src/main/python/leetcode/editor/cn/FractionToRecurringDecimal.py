"""
Title: 166.Fraction to Recurring Decimal
Title Slug: fractionToRecurringDecimal
Author: Neo
Date: 2025-09-24 12:40:00
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def fractionToDecimal(self, numerator: int, denominator: int) -> str:
        sign = '-' if numerator * denominator < 0 else ''
        numerator = abs(numerator)
        denominator = abs(denominator)

        q, r = divmod(numerator, denominator)
        if r == 0:
            return sign + str(q)

        ans = [sign + str(q) + '.']
        r_mp = {r: 1}

        while r:
            q, r = divmod(r * 10, denominator)
            ans.append(str(q))
            if r in r_mp:
                pos = r_mp[r]
                ans.insert(pos, '(')
                ans.append(')')
                break
            r_mp[r] = len(ans)
        return ''.join(ans)

# leetcode submit region end(Prohibit modification and deletion)
