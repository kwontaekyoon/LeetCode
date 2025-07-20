from collections import defaultdict
from typing import List


class Node:
    def __init__(self, name: str):
        self.name = name
        self.children = {}
        self.signature = ""

class Solution:
    def deleteDuplicateFolder(self, paths: List[List[str]]) -> List[List[str]]:
        root = Node("")
        for path in paths:
            node = root
            for folder in path:
                if folder not in node.children:
                    node.children[folder] = Node(folder)
                node = node.children[folder]

        signature_count = defaultdict(int)

        def dfs(node: Node) -> str:
            if not node.children:
                node.signature = ""
                return ""
            child_signatures = []
            for name, child in sorted(node.children.items()):
                child_signature = dfs(child)
                child_signatures.append(f"{name}({child_signature})")
            node.signature = "".join(child_signatures)
            signature_count[node.signature] += 1
            return node.signature
        
        dfs(root)
        
        result = []
        current_path = []
        
        def dfs2(node: Node) -> None:
            if node.children and signature_count[node.signature] >= 2:
                return
            current_path.append(node.name)
            result.append(current_path.copy())
            for _, child in sorted(node.children.items()):
                dfs2(child)
            current_path.pop()
        
        for _, child in sorted(root.children.items()):
            dfs2(child)
        
        return result