class Solution {
    public int sumOfSquares(int[] nums) {
        int numsLength = nums.length;
        int sum = 0;
        for(int index = 0; index < numsLength; index++ ) {
            if(numsLength%((index+1)) == 0 ) {
                sum += (nums[index]*nums[index]);
            }
        }
        return sum;
    }
}
