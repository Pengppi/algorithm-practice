"""
Title: 2131.连接两字母单词得到的最长回文串
Title Slug: longestPalindromeByConcatenatingTwoLetterWords
Author: Neo
Date: 2025-05-25 11:32:00
"""
from collections import defaultdict
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def longestPalindrome(self, words: List[str]) -> int:
        ans = 0
        mp = defaultdict(int)
        for w in words:
            rever = w[1] + w[0]
            if mp[rever] > 0:
                ans += 4
                mp[rever] -= 1
                continue
            mp[w] += 1
        for key in mp.keys():
            if key[0] == key[1] and mp[key] > 0:
                ans += 2
                break
        return ans
# leetcode submit region end(Prohibit modification and deletion)
