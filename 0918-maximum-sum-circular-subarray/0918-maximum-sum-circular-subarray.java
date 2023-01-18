class Solution {
    public int kadane(int[] nums) {
        int local = nums[0];
        int global = nums[0];
        for (int i = 1; i < nums.length; i++) {
            local = Math.max(nums[i], local + nums[i]);
            global = Math.max(global, local);
        }
        return global;
    }

    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int maxSubArraySum = kadane(nums);
        if (maxSubArraySum < 0) return maxSubArraySum;
        int totalSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum += nums[i];
            nums[i] = -nums[i];
        }
        int minSubArraySum = kadane(nums);
        return Math.max(maxSubArraySum, totalSum + minSubArraySum);
    }
}