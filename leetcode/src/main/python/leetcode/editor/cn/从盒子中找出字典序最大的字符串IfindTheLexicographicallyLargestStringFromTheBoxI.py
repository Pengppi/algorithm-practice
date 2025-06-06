"""
Title: 3403.从盒子中找出字典序最大的字符串 I
Title Slug: findTheLexicographicallyLargestStringFromTheBoxI
Author: Neo
Date: 2025-06-04 22:33:05
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def answerString(self, word: str, numFriends: int) -> str:
        if numFriends == 1:
            return word
        n = len(word)

        def compare(x, y):
            i = x + 1
            j = y + 1
            while i < n and j < n:
                if word[i] == word[j]:
                    i += 1
                    j += 1
                else:
                    return word[i] < word[j]
            return False

        mxc = max(word)
        idx = -1
        for i, c in enumerate(word):
            if c != mxc:
                continue
            if idx == -1:
                idx = i
                continue
            if compare(idx, i):
                idx = i
        sz = n - numFriends + 1
        return word[idx:idx + sz]
# leetcode submit region end(Prohibit modification and deletion)
