"""
Title: 2644.找出可整除性得分最大的整数
Title Slug: findTheMaximumDivisibilityScore
Author: Neo
Date: 2024-05-18 12:13:02
"""
from collections import Counter
from itertools import pairwise
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maxDivScore(self, nums: List[int], divisors: List[int]) -> int:
        freq_dic = Counter(nums)
        freq_list = sorted(freq_dic.keys(), reverse=True)
        max_key = freq_list[0]
        dup = len(nums) - len(freq_dic)

        divisors = sorted(set(divisors))
        max_cnt, ans = -1, 0

        for d in divisors:
            if (max_cnt - dup + 1) * d > max_key:
                break
            cnt = 0
            for x in freq_list:
                if x < d:
                    break
                if x % d == 0:
                    cnt += freq_dic[x]
            if cnt > max_cnt:
                max_cnt, ans = cnt, d
        return ans

# leetcode submit region end(Prohibit modification and deletion)
