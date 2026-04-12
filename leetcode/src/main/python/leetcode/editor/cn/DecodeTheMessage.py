"""
Title: 2325.Decode the Message
Title Slug: decodeTheMessage
Author: Neo
Date: 2026-04-12 12:19:49
"""
from string import ascii_lowercase


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def decodeMessage(self, key: str, message: str) -> str:
        mp = dict()
        i = 0
        mp[' '] = ' '
        for c in key:
            if c not in mp:
                mp[c] = ascii_lowercase[i]
                i += 1

        return ''.join([mp[c] for c in message])

# leetcode submit region end(Prohibit modification and deletion)
