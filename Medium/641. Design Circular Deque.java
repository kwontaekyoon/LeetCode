class MyCircularDeque {
    private int maxSize;
    private int curSize;
    private int[] deque;
    private int head, tail;

    public MyCircularDeque(int k) {
        maxSize = k;
        curSize = 0;
        deque = new int[maxSize];
        head = 0;
        tail = 1;
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        deque[head = (head + 1) % maxSize] = value;
        curSize++;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        deque[tail = (tail - 1 + maxSize) % maxSize] = value;
        curSize++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        head = (head - 1 + maxSize) % maxSize;
        curSize--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        tail = (tail + 1) % maxSize;
        curSize--;
        return true;
    }

    public int getFront() {
        return isEmpty() ? -1 : deque[head];
    }

    public int getRear() {
        return isEmpty() ? -1 : deque[tail];
    }

    public boolean isEmpty() {
        return curSize == 0;
    }

    public boolean isFull() {
        return curSize == maxSize;
    }
}