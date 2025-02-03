class Solution {
    public long maxArrayValue(int[] nums) {
        int numsLength  = nums.length;
        long ans[] = new long[numsLength];
        long maxAns = nums[numsLength-1];
        ans[numsLength-1] = nums[numsLength-1];
        for(int index = numsLength-2; index >= 0; index--) {
            if( ans[index+1] >= nums[index]) {
                ans[index] = ans[index+1]+nums[index];
            }
            else {
                ans[index] = nums[index];
            }
            maxAns = Long.max(maxAns, ans[index]);
        }
        return maxAns;
    }
}©leetcode
