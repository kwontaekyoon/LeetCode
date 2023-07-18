class LRUCache {

    class Node {

        Node prev;
        int key;
        int val;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }

    }

    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    int capacity;
    HashMap<Integer, Node> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head.next = tail;
        this.tail.prev = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node tmp = map.get(key);
            // connect tmp's prev and next
            tmp.prev.next = tmp.next;
            tmp.next.prev = tmp.prev;
            // connect tmp to head and head's next
            tmp.next = this.head.next;
            tmp.prev = this.head;
            // connect head's next to tmp, head to tmp
            this.head.next.prev = tmp;
            this.head.next = tmp;
            return tmp.val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (this.map.containsKey(key)) {
            Node tmp = this.map.get(key);
            this.map.remove(key);
            tmp.prev.next = tmp.next;
            tmp.next.prev = tmp.prev;
        }
        if (this.map.size() == this.capacity) {
            Node tmp = this.tail.prev;
            this.map.remove(tmp.key);
            tmp.prev.next = this.tail;
            this.tail.prev = tmp.prev;
        }
        Node tmp = new Node(key, value);
        tmp.prev = this.head;
        tmp.next = this.head.next;
        this.head.next.prev = tmp;
        this.head.next = tmp;
        this.map.put(key, tmp);
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */