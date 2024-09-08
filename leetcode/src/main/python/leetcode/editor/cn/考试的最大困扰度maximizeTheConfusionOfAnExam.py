"""
Title: 2024.考试的最大困扰度
Title Slug: maximizeTheConfusionOfAnExam
Author: Neo
Date: 2024-09-02 23:48:41
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maxConsecutiveAnswers(self, answerKey: str, k: int) -> int:
        l, r = 0, 0
        ans = 0
        c1, c2 = 0, 0
        while r < len(answerKey):
            if answerKey[r] == "T":
                c1 += 1
            else:
                c2 += 1
            while c1 > k and c2 > k:
                if answerKey[l] == "T":
                    c1 -= 1
                else:
                    c2 -= 1
                l += 1
            ans = max(ans, r - l + 1)
            r += 1
        return ans
# leetcode submit region end(Prohibit modification and deletion)
