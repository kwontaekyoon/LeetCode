from typing import List


class Solution:
    def minimumTeachings(self, n: int, languages: List[List[int]], friends: List[List[int]]) -> int:
        known = [set(language) for language in languages]
        users_to_teach = set()
        for u, v in friends:
            if not(known[u - 1] & known[v - 1]):
                users_to_teach.add(u - 1)
                users_to_teach.add(v - 1)
        result = len(users_to_teach) + 1
        for lang in range(1, n + 1):
            curr = 0
            for user in users_to_teach:
                if lang not in known[user]:
                    curr += 1
            result = min(result, curr)
        return result