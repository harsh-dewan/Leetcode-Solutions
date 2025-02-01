class Solution {
    public int maxNonDecreasingLength(int[] nums1, int[] nums2) {
        int numsLength = nums1.length;
        int[] first = new int[numsLength];
        int[] second = new int[numsLength];
        first[numsLength-1] = 1;
        second[numsLength-1] = 1;
        int maxCount = 1;
        for(int index = numsLength-2; index >= 0; index--) {
            //if we chose number from 1st array
            int temp = -1;
            if( nums1[index+1] >= nums1[index]) {
                temp = Integer.max(temp,1+first[index+1]); 
                first[index] = Integer.max(first[index],temp);
            }
            if(nums2[index+1] >= nums1[index] ) {
                temp = Integer.max(temp,1+second[index+1]);
                first[index] = Integer.max(first[index],temp);
            }
            if( temp == -1) {
                first[index] = 1;
            }
            temp=-1;
            // if we chose 2nd array 
            if( nums1[index+1] >= nums2[index]) {
                temp = Integer.max(temp, 1+first[index+1]);
                second[index] = Integer.max(second[index], temp);
            }
            if( nums2[index+1] >= nums2[index] ) {
                temp = Integer.max(temp, 1+second[index+1]);
                second[index] = Integer.max(second[index], temp);
            }
            if( temp == -1 ) {
                second[index] = 1;
            }
            maxCount = Integer.max(maxCount,Integer.max(first[index], second[index]));
        }
        return maxCount;
    }
}
