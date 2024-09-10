class ListNode(var `val`: Int) {
    var next: ListNode? = null
    constructor(`val`: Int, next: ListNode?) : this(`val`) {
        this.next = next
    }
}

class Solution {
    private fun gcd(a: Int, b: Int): Int {
        var a = a
        var b = b
        while (b != 0) {
            val temp = b
            b = a % b
            a = temp
        }
        return a
    }

    fun insertGreatestCommonDivisors(head: ListNode?): ListNode? {
        var dummy = head
        while (dummy?.next != null) {
            dummy.next = ListNode(gcd(dummy.`val`, dummy.next.`val`), dummy.next)
            dummy = dummy.next.next
        }
        return head
    }
}

