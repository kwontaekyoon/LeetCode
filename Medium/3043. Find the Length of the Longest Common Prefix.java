import java.util.HashSet;

class Trie {
    class Node {
        Node[] child;

        Node() {
            child = new Node[10];
        }
    }

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        final var root = new Node();
        for (int num : arr1) {
            insert(num, root);
        }
        int res = 0;
        for (int num : arr2) {
            res = Math.max(res, search(num, root));
        }
        return res;
    }

    private int search(int num, Node root) {
        int size = 0;
        for (var c : String.valueOf(num).toCharArray()) {
            int curr = c - '0';
            if (root.child[curr] == null) {
                break;
            }
            size++;
            root = root.child[curr];
        }
        return size;
    }

    private void insert(int num, Node root) {
        for (var c : String.valueOf(num).toCharArray()) {
            int curr = c - '0';
            if (root.child[curr] == null) {
                root.child[curr] = new Node();
            }
            root = root.child[curr];
        }
    }
}

class HashTable {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        final var prefixs = new HashSet<Integer>();
        for (int num : arr1) {
            while (num > 0) {
                prefixs.add(num);
                num /= 10;
            }
        }
        int res = 0;
        for (int num : arr2) {
            while (num > 0) {
                if (prefixs.contains(num)) {
                    res = Math.max(res, (int) Math.log10(num) + 1);
                    break;
                }
                num /= 10;
            }
        }
        return res;
    }
}