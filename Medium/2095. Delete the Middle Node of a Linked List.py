# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def deleteMiddle(self, head: Optional[ListNode]) -> Optional[ListNode]:
        n = 0
        dummy = head
        while dummy:
            n += 1
            dummy = dummy.next
        dummy = ListNode(0, head)
        head = dummy
        for i in range(n // 2):
            head = head.next
        head.next = head.next.next
        return dummy.next
