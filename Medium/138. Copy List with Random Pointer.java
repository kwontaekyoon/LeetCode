/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> hm = new HashMap<>();
        Node newHeadOne = head;
        Node last = null;
        Node newHeadTwo = head;
        while (newHeadOne != null) {
            Node node = new Node(newHeadOne.val);
            if (last != null) {
                hm.get(last).next = node;
            }
            last = newHeadOne;
            hm.put(newHeadOne, node);
            newHeadOne = newHeadOne.next;
        }
        while (newHeadTwo != null) {
            hm.get(newHeadTwo).random = hm.get(newHeadTwo.random);
            newHeadTwo = newHeadTwo.next;
        }
        return hm.get(head);
    }
}