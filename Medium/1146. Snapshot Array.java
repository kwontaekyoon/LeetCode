class SnapshotArray {
    List[] snapshots;
    int snapId;

    public SnapshotArray(int length) {
        snapshots = new ArrayList[length];
        for (int i = 0; i < length; i++) {
            snapshots[i] = new ArrayList<Integer>();
            snapshots[i].add(0);
        }
        snapId = 0;
    }

    public void set(int index, int val) {
        var snapshot = snapshots[index];
        while (snapshot.size() < snapId) {
            snapshot.add(snapshot.get(snapshot.size() - 1));
        }
        if (snapshot.size() > snapId) {
            snapshot.set(snapId, val);
        } else {
            snapshot.add(val);
        }
    }

    public int snap() {
        return snapId++;
    }

    public int get(int index, int snap_id) {
        List<Integer> snapshot = snapshots[index];
        if (snapshot.size() > snap_id) {
            return snapshot.get(snap_id);
        } else {
            return snapshot.get(snapshot.size() - 1);
        }
    }
}

class SnapshotArray1 {
    TreeMap<Integer, Integer>[] snapshots;
    int snapId;

    public SnapshotArray1(int length) {
        snapshots = new TreeMap[length];
        for (int i = 0; i < length; i++) {
            snapshots[i] = new TreeMap<>();
            snapshots[i].put(0, 0);
        }
        snapId = 0;
    }

    public void set(int index, int val) {
        snapshots[index].put(snapId, val);
    }

    public int snap() {
        return snapId++;
    }

    public int get(int index, int snap_id) {
        return snapshots[index].floorEntry(snap_id).getValue();
    }
}