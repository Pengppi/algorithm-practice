"""
Title: 1255.Maximum Score Words Formed by Letters
Title Slug: maximumScoreWordsFormedByLetters
Author: Neo
Date: 2025-11-16 18:04:30
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maxScoreWords(self, words: List[str], letters: List[str], score: List[int]) -> int:
        score = dict(zip(ascii_lowercase, score))
        left = Counter(letters)
        ans = 0

        @lru_cache(None)
        def dfs(i: int, tot: int) -> None:
            if i < 0:
                nonlocal ans
                ans = max(ans, tot)
                return

            dfs(i - 1, tot)

            for j, c in enumerate(words[i]):
                if left[c] == 0:
                    for d in words[i][:j]:
                        left[d] += 1
                    return
                left[c] -= 1
                tot += score[c]

            dfs(i - 1, tot)
            for c in words[i]:
                left[c] += 1

        dfs(len(words) - 1, 0)

        return ans

        # leetcode submit region end(Prohibit modification and deletion)
