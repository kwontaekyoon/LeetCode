# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def createBinaryTree(self, descriptions: List[List[int]]) -> Optional[TreeNode]:
        node_dict = {}
        child_set = set()
        root = None
        for val, child, isLeft in descriptions:
            if val in node_dict:
                tree = node_dict[val]
            else:
                tree = TreeNode(val)
                node_dict[val] = tree
            if child in node_dict:
                child_tree = node_dict[child]
            else:
                child_tree = TreeNode(child)
                node_dict[child] = child_tree
            child_set.add(child_tree)
            if isLeft:
                tree.left = child_tree
            else:
                tree.right = child_tree
        for root_value, tree in node_dict.items():
            if tree not in child_set:
                return tree
