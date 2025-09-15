# """
# Title: 966.Vowel Spellchecker
# Title Slug: vowelSpellchecker
# Author: Neo
# Date: 2025-09-14 15:16:28
# """
# from collections import defaultdict
# from typing import List
#
#
# # leetcode submit region begin(Prohibit modification and deletion)
# class Solution:
#     def spellchecker(self, wordlist: List[str], queries: List[str]) -> List[str]:
#         word_map = dict()
#         translator = str.maketrans('aeiou', '?????')
#         for word in reversed(wordlist):
#             w = word.lower()
#             word_map[w] = word
#             word_map[w.translate(translator)] = word
#         word_set = set(wordlist)
#         for i, query in enumerate(queries):
#             if query in word_set:
#                 continue
#             low = query.lower()
#             if low in word_map:
#                 queries[i] = word_map[low]
#                 continue
#             low_trans = low.translate(translator)
#             if low_trans in word_map:
#                 queries[i] = word_map[low_trans]
#                 continue
#             queries[i] = ''
#         return queries
#
# # leetcode submit region end(Prohibit modification and deletion)
