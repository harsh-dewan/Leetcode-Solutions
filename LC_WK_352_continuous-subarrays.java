class Solution {
    public long continuousSubarrays(int[] nums) {
        int numsLength = nums.length;
        long[] save = new long[numsLength];
        save[numsLength-1] = 1;
        long totalCount = 1;
        int minSoFar = nums[numsLength-1], maxSoFar = nums[numsLength-1];
        for(int index = numsLength-2; index >= 0; index-- ) {
            if( Math.abs(nums[index] - minSoFar) <= 2 &&
                Math.abs(nums[index] - maxSoFar) <= 2 ) {
                minSoFar  = Integer.min(minSoFar, nums[index]);
                maxSoFar = Integer.max(maxSoFar, nums[index]);
                save[index] = 1 + save[index+1];
            }
            else {
                int tempCount = 1;
                minSoFar = nums[index];
                maxSoFar = nums[index];
                for(int index1 = index+1; index1 < numsLength; index1++) {
                    if(Math.abs(nums[index]-nums[index1]) <= 2 )
                    {
                            tempCount++;
                            minSoFar = Integer.min(minSoFar, nums[index1]);
                maxSoFar = Integer.max(maxSoFar, nums[index1]);
                    }
                    else break;             
                }
                save[index] = tempCount;
            }
            totalCount += save[index];
        }
        return totalCount;
    }
}
