class Solution {
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int sum = 0;
        int numsLength = nums.size();
        for(int index = 0; index < numsLength; index++) {
            if(Integer.bitCount(index) == k ) sum+=nums.get(index);
        }
        return sum;
    }
}
