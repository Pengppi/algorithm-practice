"""
Title: 2502.设计内存分配器
Title Slug: designMemoryAllocator
Author: Neo
Date: 2025-02-25 13:12:23
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Allocator:

    def __init__(self, n: int):
        self.cache = [0] * n

    def allocate(self, size: int, mID: int) -> int:
        cnt = 0
        cache = self.cache
        for i, x in enumerate(cache):
            if x != 0:
                cnt = 0
                continue
            cnt += 1
            if cnt == size:
                cache[i - size + 1:i + 1] = [mID] * size
                return i - size + 1
        return -1

    def freeMemory(self, mID: int) -> int:
        cnt = 0
        cache = self.cache
        for i, x in enumerate(cache):
            if x == mID:
                cnt += 1
                cache[i] = 0
        return cnt

# Your Allocator object will be instantiated and called as such:
# obj = Allocator(n)
# param_1 = obj.allocate(size,mID)
# param_2 = obj.freeMemory(mID)
# leetcode submit region end(Prohibit modification and deletion)
