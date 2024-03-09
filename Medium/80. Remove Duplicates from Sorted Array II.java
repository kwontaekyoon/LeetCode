class Array {
    public int removeDuplicates(int[] nums) {
        int num = -10001;
        int k = 0, s = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > num) {
                nums[k++] = nums[i];
                num = nums[i];
                s = 1;
            } else if (nums[i] == num) {
                if (s < 2) {
                    nums[k++] = nums[i];
                    s++;
                }
            }
        }
        return k;
    }
}

class TwoPointers {
    public int removeDuplicates(int[] nums) {
        int j = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[j - 2]) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }
}