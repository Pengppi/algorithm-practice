"""
Title: 2288.价格减免
Title Slug: applyDiscountToPrices
Author: Neo
Date: 2024-06-18 11:15:36
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def discountPrices(self, sentence: str, discount: int) -> str:
        ans = []
        discount = (100 - discount) / 100
        words = sentence.split(" ")
        for word in words:
            if word.startswith('$') and str.isdigit(word[1:]):
                num = int(word[1:])
                ans.append("$" + f'{num * discount:.2f}')
            else:
                ans.append(word)
        return str.join(" ", ans)
# leetcode submit region end(Prohibit modification and deletion)
