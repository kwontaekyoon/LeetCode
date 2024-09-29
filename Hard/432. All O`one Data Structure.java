import java.util.HashMap;
import java.util.Map;

class AllOne {

    class Node {
        String key;
        int cnt;
        Node prev, next;

        Node(int cnt, String key) {
            this.cnt = cnt;
            this.key = key;
        }

        void remove() {
            this.prev.next = this.next;
            this.next.prev = this.prev;
        }
    }

    final Map<String, Node> keyToNode;
    Node head, tail;

    public AllOne() {
        this.keyToNode = new HashMap<>();
        this.head = new Node(0, "");
        this.tail = new Node(Integer.MAX_VALUE, "");
        head.next = tail;
        tail.prev = head;
    }

    public void swap(Node prev, Node next) {
        Node prevPrev = prev.prev, nextNext = next.next;
        prevPrev.next = next;
        next.next = prev;
        prev.next = nextNext;
        nextNext.prev = prev;
        prev.prev = next;
        next.prev = prevPrev;
    }

    public void inc(String key) {
        Node curr = keyToNode.getOrDefault(key, new Node(0, key));
        if (curr.cnt == 0) {
            curr.prev = head;
            curr.next = head.next;
            curr.next.prev = curr;
            head.next = curr;
            keyToNode.put(key, curr);
        } else {
            while (curr.next.cnt == curr.cnt) {
                swap(curr, curr.next);
            }
        }
        curr.cnt++;
    }

    public void dec(String key) {
        Node curr = keyToNode.get(key);
        while (curr.prev.cnt == curr.cnt) {
            swap(curr.prev, curr);
        }
        if (--curr.cnt == 0) {
            curr.remove();
            keyToNode.remove(key);
        }
    }

    public String getMaxKey() {
        return tail.prev.key;
    }

    public String getMinKey() {
        return head.next.key;
    }
}