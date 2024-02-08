class Solution {
    int[] original;

    public Solution(int[] nums) {
        original = nums;
    }
    
    public int[] reset() {
        return original;
    }
    
    public int[] shuffle() {
        Random rand = new Random();
        int n = original.length;
        int[] shuffled = Arrays.copyOf(original, n);
        for (int i = n - 1; i > -1; i--) {
            int j = rand.nextInt(i + 1);
            int tmp = shuffled[i];
            shuffled[i] = shuffled[j];
            shuffled[j] = tmp;
        }
        return shuffled;
    }
}