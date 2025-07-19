class Trie {

    class Node {
        boolean eow;
        Node children[];
        Node() {
            children = new Node[27];
        }
    }

    Node root;
    Trie() {
        root = new Node();
    }
    
    public void insert(String s) {
        Node curr = root;
        for (char ch : s.toCharArray()) {
            int idx = ch - 'a';
            if (ch == '/') {
                idx = 26;
            }
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr = curr.children[26] = new Node();
        curr.eow = true;
    }
    
    public boolean search(String s){
        Node curr = root;
        for (char ch : s.toCharArray()){
            int idx = ch - 'a';
            if (ch == '/') {
                idx = 26;
            }
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
            if (curr.eow == true) {
                return true;
            }
        }
        return false;
    }
}

class Solution {
    public List<String> removeSubfolders(String[] folder) {
        final var result = new ArrayList<String>();
        final var trie = new Trie();

        Arrays.sort(folder);

        for (final var s : folder) {
            if (!trie.search(s)) {
                result.add(s);
                trie.insert(s);
            }
        }

        return result;
    }
}

class BF {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        var prev = "//";
        final var result = new ArrayList<String>();
        for (final var path : folder) {
            if (!path.startsWith(prev + "/")) {
                prev = path;
                result.add(prev);
            }
        }
        return result;
    }
}