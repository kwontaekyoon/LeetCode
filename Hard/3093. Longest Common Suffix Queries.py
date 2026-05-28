class TrieNode:
    def __init__(self):
        self.children = {}
        self.best = -1  # index of best word passing through this node

class Solution:
    def stringIndices(self, wordsContainer: List[str], wordsQuery: List[str]) -> List[int]:
        root = TrieNode()

        def update(node, idx):
            # Keep the candidate with longer word length, 
            # break ties by earlier index
            cur_idx = node.best
            if cur_idx == -1:
                node.best = idx
            else:
                cur_len = len(wordsContainer[cur_idx])
                new_len = len(wordsContainer[idx])
                if new_len < cur_len or (new_len == cur_len and idx < cur_idx):
                    node.best = idx

        # Insert reversed words into trie
        for idx, word in enumerate(wordsContainer):
            cur = root
            update(cur, idx)                        # root = empty suffix, all words qualify
            for c in reversed(word):
                if c not in cur.children:
                    cur.children[c] = TrieNode()
                cur = cur.children[c]
                update(cur, idx)

        # Query: walk reversed query as far as possible, return best at deepest node
        def search(word):
            cur = root
            for c in reversed(word):
                if c not in cur.children:
                    break
                cur = cur.children[c]
            return cur.best

        return [search(q) for q in wordsQuery]
