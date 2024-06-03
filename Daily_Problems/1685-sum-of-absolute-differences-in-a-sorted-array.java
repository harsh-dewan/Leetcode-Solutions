class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int totalSum = 0;
        int length = nums.length;
        int[] prefix  = new int[length];
        totalSum = nums[0];
        prefix[0] = nums[0];
        for(int i = 1; i < length; i++ ) {
            prefix[i] = prefix[i-1]+nums[i];
            totalSum += nums[i];
        }
        int[] result = new int[length];
        for(int i = 0; i < length; i++ ){
            result[i] = Math.abs((nums[i]*(i+1))-prefix[i]);
            int rest = totalSum - prefix[i];
            result[i] += Math.abs((nums[i]*(length-1-i))-rest);
        }
        return result;
    }
}
