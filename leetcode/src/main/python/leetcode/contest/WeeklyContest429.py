import bisect
import heapq
from typing import List


class Solution:
    def minLength(self, s: str, numOps: int) -> int:
        n = len(s)

        def check_one():
            cnt1 = cnt2 = 0
            # 0101
            # 1010
            for i in range(n):
                if i & 1 == 0:
                    if s[i] == '1':
                        cnt1 += 1
                    else:
                        cnt2 += 1
                else:
                    if s[i] == '0':
                        cnt1 += 1
                    else:
                        cnt2 += 1
                if cnt1 > numOps or cnt2 > numOps:
                    return False
            return True

        def check(k):
            if k == 1:
                return check_one()
            cnt = 0
            l = 0
            last = s[l]
            for r in range(n):
                if last != s[r]:
                    last = s[r]
                    l = r
                    continue
                if r - l + 1 <= k:
                    continue
                cnt += 1
                if cnt > numOps:
                    return False
                last = '0' if last == '1' else '1'
                l = r
                if r < n - 1 and s[r] != s[r + 1] and (r - 1 == 0 or s[r - 1] == s[r - 2]):
                    l = r + 1
            return True

        return bisect.bisect_left(range(n), x=True, lo=1, key=check)

    def maxDistinctElements(self, nums: List[int], k: int) -> int:
        nums.sort()
        nums[0] -= k
        ans = 1
        for i in range(1, len(nums)):
            last = nums[i - 1]
            if last >= nums[i] + k:
                nums[i] = last
                continue
            else:
                nums[i] = max(last + 1, nums[i] - k)
                ans += 1
        return ans

    def minimumOperations(self, nums: List[int]) -> int:
        n = len(nums)
        st = set()
        for i in range(n - 1, -1, -1):
            if nums[i] in st:
                return i // 3 + 1
            st.add(nums[i])
        return 0
