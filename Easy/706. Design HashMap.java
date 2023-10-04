class MyHashMap {
    private int size;
    private List<int[]>[] map;

    public MyHashMap() {
        size = 1000;
        map = new ArrayList[size];
        for (int i = 0; i < size; i++) {
            map[i] = new ArrayList<>();
        }
    }

    public void put(int key, int value) {
        int index = key % size;
        List<int[]> bucket = map[index];
        for (int[] pair : bucket) {
            if (pair[0] == key) {
                pair[1] = value;
                return;
            }
        }
        bucket.add(new int[] { key, value });
    }

    public int get(int key) {
        int index = key % size;
        List<int[]> bucket = map[index];
        for (int[] pair : bucket) {
            if (pair[0] == key) {
                return pair[1];
            }
        }
        return -1;
    }

    public void remove(int key) {
        int index = key % size;
        List<int[]> bucket = map[index];
        for (int i = 0; i < bucket.size(); i++) {
            if (bucket.get(i)[0] == key) {
                bucket.remove(i);
                return;
            }
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */