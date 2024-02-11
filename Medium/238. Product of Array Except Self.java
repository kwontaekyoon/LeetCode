class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] products = new int[n];
        Arrays.fill(products, 1);
        for (int i = 0, pre = 1; i < n - 1; i++) {
            pre *= nums[i];
            products[i + 1] *= pre;
        }
        for (int i = n - 1, pre = 1; i > 0; i--) {
            pre *= nums[i];
            products[i - 1] *= pre;
        }
        return products;
    }
}