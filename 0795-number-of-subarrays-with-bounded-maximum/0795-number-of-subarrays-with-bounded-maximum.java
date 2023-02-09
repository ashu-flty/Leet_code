class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        return subarraysWithMax(nums, right) - subarraysWithMax(nums, left - 1);
    }
    
    private int subarraysWithMax(int[] nums, int max) {
        int n = nums.length;
        int i = 0, j = 0, count = 0, maxTillNow = Integer.MIN_VALUE;
        
        while(j < n) {
            maxTillNow = Math.max(maxTillNow, nums[j]);
            
            if(maxTillNow <= max) {
                count += (j - i + 1);
            } else {
                i = j + 1;
                maxTillNow = Integer.MIN_VALUE;
            }
            j++;
        }
        
        return count;
    }
} 