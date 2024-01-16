class RandomizedSet {
    private Map<Integer, Integer> valToIdx;
    private List<Integer> vals;
    private Random random;

    public RandomizedSet() {
        valToIdx = new HashMap<>();
        vals = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (valToIdx.containsKey(val)) {
            return false;
        }
        valToIdx.put(val, vals.size());
        vals.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!valToIdx.containsKey(val)) {
            return false;
        }
        int valIdx = valToIdx.get(val);
        int lastIdx = vals.size() - 1;
        if (valIdx != lastIdx) {
            valToIdx.put(vals.get(lastIdx), valIdx);
            vals.set(valIdx, vals.get(lastIdx));
        }
        valToIdx.remove(val);
        vals.remove(lastIdx);
        return true;
    }

    public int getRandom() {
        return vals.get(random.nextInt(vals.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */