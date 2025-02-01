class Solution {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int numsLength = nums.length;
        int maxCount = 0;
        for(int index = 0; index < numsLength; index++ ) {
            if( nums[index] > threshold) continue;
            if( nums[index]%2 != 0 ) continue;
            int count = 1;
            for(int index1 = index+1; index1 < numsLength; index1++ ) {
                if( nums[index1] > threshold) break;
                if( nums[index1]%2 != nums[index1-1]%2) count++;
                else break;
            }
            maxCount = Integer.max(maxCount, count);
        }
        return maxCount;
    }
}
