# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
      
class Solution:
    def pairSum(self, head: Optional[ListNode]) -> int:
        vals = []
        while head:
            vals.append(head.val)
            head = head.next
        return max(vals[i] + vals[-(i + 1)] for i in range(len(vals) // 2))

class Solution1:
    def pairSum(self, head: Optional[ListNode]) -> int:
        n = 0
        new_head = head
        while new_head:
            n += 1
            new_head = new_head.next
        twin_sum = [0] * (n // 2)
        for i in range(n // 2):
            twin_sum[i] += head.val
            head = head.next
        for i in range(1, n // 2 + 1):
            twin_sum[-i] += head.val
            head = head.next
        return max(twin_sum)
