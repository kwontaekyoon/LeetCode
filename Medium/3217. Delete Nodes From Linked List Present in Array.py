# Definition for singly-linked list.
from typing import List, Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
        
class Solution:
    def modifiedList(self, nums: List[int], head: Optional[ListNode]) -> Optional[ListNode]:
        to_remove = set(nums)
        result = dummy = ListNode(0, head)
        while head:
            if head.val in to_remove:
                dummy.next = head.next
            else:
                dummy = head
            head = head.next
        return result.next