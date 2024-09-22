from cmath import inf
from collections import Counter, defaultdict
from heapq import heappop
from typing import List


class Solution:
    def reportSpam(self, message: List[str], bannedWords: List[str]) -> bool:
        st = set(bannedWords)
        count = 0
        for word in message:
            if word in st:
                count += 1
                if count >= 2:
                    return True
        return False

    def minNumberOfSeconds(self, mountainHeight: int, workerTimes: List[int]) -> int:
        def check(limit):
            s = 0
            for timeUnit in workerTimes:
                h = int((-1 + ((1 + 8 * limit / timeUnit) ** 0.5)) / 2)
                s += h
                if s >= mountainHeight:
                    return True
            return False

        l = 0
        r = max(workerTimes) * mountainHeight * mountainHeight
        while l < r:
            mid = (l + r) // 2
            if check(mid):
                r = mid
            else:
                l = mid + 1

        return l

    def validSubstringCount(self, word1: str, word2: str) -> int:
        n1 = len(word1)
        n2 = len(word2)
        counter = Counter(word2)
        ans = 0
        sub_cnt = defaultdict(int)
        l = 0
        lack = set()
        for r, c in enumerate(word1):
            sub_cnt[c] += 1
            if lack and c in lack and sub_cnt[c] >= counter[c]:
                lack.remove(c)
            while r - l + 1 >= n2 and not lack:
                for ch in counter:
                    if sub_cnt[ch] < counter[ch]:
                        lack.add(ch)
                if lack:
                    break
                ans += n1 - r
                sub_cnt[word1[l]] -= 1
                if sub_cnt[word1[l]] < counter[word1[l]]:
                    lack.add(word1[l])
                l += 1

        return ans
