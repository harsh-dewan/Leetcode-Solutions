class Solution {
    public int numberOfGoodSubarraySplits(int[] nums) {
        int numsLength = nums.length;
        long[] ans = new long[numsLength]; 
        long zcount = 0, first1 = 0, MOD = 1000000007;
        
        if (nums[numsLength - 1] == 1) {
            ans[numsLength - 1] = 1;
            first1 = 1;
        }
        if (nums[numsLength - 1] == 0) zcount = 1;
        
        for (int index = numsLength - 2; index >= 0; index--) {
            if (nums[index] == 0) {
                zcount += 1;
                ans[index] = ans[index + 1] % MOD;  // Store result as long
            } else if (nums[index] == 1 && first1 == 0) {
                first1 = 1;
                ans[index] = 1;
                zcount = 0;
            } else {
                ans[index] = (ans[index + 1] % MOD + ((zcount % MOD) * (ans[index + 1] % MOD)) % MOD) % MOD;
                zcount = 0;
            }
        }
        
        return (int) (ans[0] % MOD);  
    }
}
