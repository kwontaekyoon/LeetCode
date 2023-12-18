class Solution {
    public int maxProductDifference(int[] nums) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MAX_VALUE;
        int fourth = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num >= second) {
                if (num > first) {
                    second = first;
                    first = num;
                } else {
                    second = num;
                }
            }
            if (num <= fourth) {
                if (num < third) {
                    fourth = third;
                    third = num;
                } else {
                    fourth = num;
                }
            }
        }
        return first * second - third * fourth;
    }
}