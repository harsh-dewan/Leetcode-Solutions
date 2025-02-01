class Solution {
    public int maximumJumps(int[] nums, int target) {
        int numsLength = nums.length;
        int[] jumps = new int[numsLength];
        jumps[numsLength-1] = 0;
        for(int index1 = numsLength-2; index1 >= 0; index1-- ) {
            jumps[index1] = -1;
            for(int index2 = index1+1; index2 < numsLength; index2++ ) {
                if( jumps[index2] == -1 ) continue;
                if( (-1*target) <= (nums[index2]-nums[index1]) && 
                    ((nums[index2]-nums[index1]) <= target) ) {
                    jumps[index1] = Integer.max(jumps[index1],jumps[index2]+1);
                }
            }
        }
        return jumps[0];
    }
}
