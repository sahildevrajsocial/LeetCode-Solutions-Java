class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int a = nums.length - 1;
        int r1 = nums[a] * nums[a - 1] * nums[a - 2];
        int r2 = nums[0] * nums[1] * nums[a];
        return Math.max(r1, r2);
    }
}