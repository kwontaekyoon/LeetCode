class OnePass {
    public void sortColors(int[] nums) {
        final int N = nums.length;
        int two = N - 1, zero = 0;
        for (int i = 0; i < N; i++) {
            while (nums[i] == 2 && i < two) {
                swap(nums, i, two--);
            }
            while (nums[i] == 0 && i > zero) {
                swap(nums, i, zero++);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

class TwoPass {
    public void sortColors(int[] nums) {
        int[] freq = new int[3];
        for (int num : nums) {
            freq[num]++;
        }
        for (int i = 0; i < freq[0]; i++) {
            nums[i] = 0;
        }
        freq[1] += freq[0];
        for (int i = freq[0]; i < freq[1]; i++) {
            nums[i] = 1;
        }
        freq[2] += freq[1];
        for (int i = freq[1]; i < freq[2]; i++) {
            nums[i] = 2;
        }
    }
}