class Solution {
    public int findValueOfPartition(int[] nums) {
        int numsLength = nums.length;
        Arrays.sort(nums);
        int minDiff = -1;
        for(int index = 1; index < numsLength; index++ ) {
            int currDiff = nums[index] - nums[index-1];
            if( minDiff == -1 ) minDiff = currDiff;
            else minDiff = Integer.min(minDiff, currDiff);
        }
        return minDiff;
    }
}
